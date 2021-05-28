package com.bl.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.insurance.dto.ClaimPolicyDTO;
import com.bl.insurance.dto.DecodedToken;
import com.bl.insurance.dto.PolicyDetailsDTO;
import com.bl.insurance.model.ClaimPolicy;
import com.bl.insurance.model.PolicyDetails;
import com.bl.insurance.model.User;
import com.bl.insurance.repository.ClaimPolicyRepository;
import com.bl.insurance.repository.IUserRepository;
import com.bl.insurance.repository.PolicyDetailsRepository;
import com.bl.insurance.utility.TokenGenerator;
import com.bl.insurance.exception.UserException;

@Service
public class ClaimService implements IClaimService{

	@Autowired
	private TokenGenerator tokenGenerator;

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private PolicyDetailsRepository policyDetailsRepo;

	@Autowired
	private ClaimPolicyRepository claimPolicyRepo;

	@Override
	public PolicyDetails createPolicy(String token, PolicyDetailsDTO policyDetails) {
		DecodedToken decodedToken = tokenGenerator.decodeToken(token);
		Optional<PolicyDetails> byPolicyNumber = policyDetailsRepo.findByUserIdAndPolicyNo(decodedToken.getUserId(), policyDetails.getPolicyNumber());
		if (byPolicyNumber.isPresent()) {
			throw new UserException("Policy Already Exists");
		}
		PolicyDetails policyData = new PolicyDetails(policyDetails);
		policyData.setUserId(decodedToken.getUserId());
		Optional<User> userData = userRepo.findByUserId(decodedToken.getUserId());
		userData.get().getPolicyDetails().add(policyData);
		userRepo.save(userData.get());
		PolicyDetails savePolicy = policyDetailsRepo.save(policyData);
		return savePolicy;
	}

	@Override
	public List<PolicyDetails> getUserPolicies(String token) {
		DecodedToken decodedToken = tokenGenerator.decodeToken(token);
		List<PolicyDetails> policyData = policyDetailsRepo.findByUserId(decodedToken.getUserId());
		if (policyData.isEmpty()) {
			throw new UserException("Policy does not exists");
		} else {
			for ( PolicyDetails policy : policyData) {
				Optional<ClaimPolicy> claimByPolicy = claimPolicyRepo.findByPolicyNumber(policy.getPolicyNo());
				if(claimByPolicy.isPresent()){
					policy.setClaimpolicy(claimByPolicy.get());
				}
			}
			return policyData;
		}
	}

	@Override
	public ClaimPolicy makeClaim(String token, Long policyNumber, ClaimPolicyDTO claimPolicyDTO) {
		DecodedToken decodedToken = tokenGenerator.decodeToken(token);
		Optional<PolicyDetails> policy = policyDetailsRepo.findByUserIdAndPolicyNo(decodedToken.getUserId(), policyNumber);
		Optional<ClaimPolicy> claimByPolicy = claimPolicyRepo.findByPolicyNumber(policyNumber);
		if (policy.isPresent() & !claimByPolicy.isPresent()) {
			ClaimPolicy claimPolicy = new ClaimPolicy(claimPolicyDTO);
			claimPolicy.setPolicyNumber(policyNumber);
			policyDetailsRepo.save(policy.get());
			ClaimPolicy saveClaim = claimPolicyRepo.save(claimPolicy);
			return saveClaim;
		} else {
			throw new UserException("Policy Does Not Exists");
		}
	}

}
