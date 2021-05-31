package com.bl.insurance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.insurance.dto.DecodedToken;
import com.bl.insurance.exception.UserException;
import com.bl.insurance.model.ClaimPolicy;
import com.bl.insurance.model.PolicyDetails;
import com.bl.insurance.model.ReportGeneration;
import com.bl.insurance.model.User;
import com.bl.insurance.repository.ClaimPolicyRepository;
import com.bl.insurance.repository.IUserRepository;
import com.bl.insurance.repository.PolicyDetailsRepository;
import com.bl.insurance.repository.ReportGenerationRepository;
import com.bl.insurance.utility.TokenGenerator;

@Service
public class ClaimHandlerService implements IClaimHandlerService{

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private PolicyDetailsRepository policyDetailsRepo;

	@Autowired
	private ClaimPolicyRepository claimPolicyRepo;

	@Autowired
	private ReportGenerationRepository reportRepo;

	@Autowired
	private TokenGenerator tokenGenerator;

	@Override
	public ReportGeneration generateReport(String token, Long policyNumber, Long claimNumber) {
		DecodedToken decode = tokenGenerator.decodeToken(token);
		if(decode.getRole() == "Insured") {
			throw new UserException("Invalid Role");
		}	        
		Optional<PolicyDetails> policies = policyDetailsRepo.findByUserIdAndPolicyNo(decode.getUserId(), policyNumber);
		Optional<ClaimPolicy> claims = claimPolicyRepo.findByClaimNumber(claimNumber);
		if(policies.isPresent() && claims.isPresent()) {
			ReportGeneration reportGeneration = new ReportGeneration();
			reportGeneration.setClaimNo(claims.get().getClaimNumber());
			reportGeneration.setClaimReason(claims.get().getClaimReason());
			reportGeneration.setClaimType(claims.get().getClaimType());
			reportGeneration.setDetails(this.userDetails(token,policyNumber,claimNumber));
			return reportRepo.save(reportGeneration);
		}else {
			throw new UserException("Report Does not Exists");
		}
	}

	@Override
	public User userDetails(String token, Long policyNumber, Long claimNumber) {
		DecodedToken decode = tokenGenerator.decodeToken(token);
		if(decode.getRole() == "Insured") {
			throw new UserException("Invalid Role");
		}
		Optional<User> role = userRepo.findByUserId(decode.getUserId());
		Optional<PolicyDetails> policies = policyDetailsRepo.findByUserIdAndPolicyNo(decode.getUserId(), policyNumber);
		Optional<ClaimPolicy> claims = claimPolicyRepo.findByClaimNumber(claimNumber);
		if (policies.isPresent() && claims.isPresent()) {
			role.get().getPolicyDetails().add(policies.get());
		}else 
			throw new UserException("User Not Found");
		return role.get();
	}
}
