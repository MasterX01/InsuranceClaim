package com.bl.insurance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bl.insurance.dto.ClaimPolicyDTO;
import com.bl.insurance.dto.PolicyDetailsDTO;
import com.bl.insurance.dto.ResponseDTO;
import com.bl.insurance.model.ClaimPolicy;
import com.bl.insurance.model.PolicyDetails;
import com.bl.insurance.service.IClaimService;


@RestController
@RequestMapping("/insured")
public class InsuredController {

	@Autowired
	private IClaimService claimService;
	
	
	@PostMapping("/createpolicy")
    public ResponseEntity<ResponseDTO> CreatePolicy(@RequestHeader("Authorization") String token,@Valid @RequestBody PolicyDetailsDTO policyData) {
        try{
        	PolicyDetails policyDetails  = claimService.createPolicy(token, policyData);
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(policyDetails, "Operation Successfull"), HttpStatus.OK);
        }catch (Exception e) {
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage(), "Error"), HttpStatus.BAD_REQUEST);
		}
    }

    @GetMapping("/getpolicy")
    public ResponseEntity<ResponseDTO> getUserPolicies(@RequestHeader("Authorization") String token) {
    	try {
    		List<PolicyDetails> policyData = claimService.getUserPolicies(token);
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(policyData, "Operation Successfull"), HttpStatus.OK);
    	}catch (Exception e) {
    		return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage(), "Error"), HttpStatus.BAD_REQUEST);
		}
    }

    @PutMapping("/makeclaim")
    public ResponseEntity<ResponseDTO> claimPolicy(@RequestHeader("Authorization") String token,@RequestParam("policyNumber") Long policyNumber,@Valid @RequestBody ClaimPolicyDTO claimPolicyDTO) {
        try {
        	ClaimPolicy claimPolicy = claimService.makeClaim(token,policyNumber, claimPolicyDTO);
    		return new ResponseEntity<ResponseDTO>(new ResponseDTO(claimPolicy, "Operation Successfull"), HttpStatus.OK);
        }catch(Exception e){
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage(), "Error"), HttpStatus.BAD_REQUEST);
        }
    }

}
