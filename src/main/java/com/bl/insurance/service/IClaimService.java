package com.bl.insurance.service;

import java.util.List;

import com.bl.insurance.dto.ClaimPolicyDTO;
import com.bl.insurance.dto.PolicyDetailsDTO;
import com.bl.insurance.model.ClaimPolicy;
import com.bl.insurance.model.PolicyDetails;


public interface IClaimService {
	
    PolicyDetails createPolicy(String token,PolicyDetailsDTO policyDataDTO);

    List<PolicyDetails> getUserPolicies(String token);

    ClaimPolicy makeClaim(String token, Long policyNumber, ClaimPolicyDTO claimPolicyDTO);

}
