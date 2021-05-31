package com.bl.insurance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.insurance.dto.ResponseDTO;
import com.bl.insurance.dto.SignupDTO;
import com.bl.insurance.model.User;
import com.bl.insurance.service.IClaimAdjusterService;


/**
 * Controller for Admin/Claim Adjuster to create users
 * @author Akash Saxena
 */
@RestController
@RequestMapping("/claimadjuster")
public class ClaimAdjusterController {

	@Autowired
	private IClaimAdjusterService claimAdjuster;
	
	/**
	 * API for creating the first claim adjuster account
	 * @param signup
	 * @return user data
	 */
	@PostMapping("/firstadmin")
    public ResponseEntity<ResponseDTO> firstAdmin(@Valid @RequestBody SignupDTO signup) {
        User userData = null;
        try {
        	userData = claimAdjuster.firstClaimAdjuster(signup);
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(userData, "First User Registered Successfully"), HttpStatus.OK);
        }catch (Exception e) {
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage(), "Error"), HttpStatus.OK);
		}
    }

	/**
	 * API to create user's accounts
	 * @param token of Admin login
	 * @param signup
	 * @return userdata
	 */
    @PostMapping("/registration")
    public ResponseEntity<ResponseDTO> userRegistration(@Valid @RequestHeader("Authorization") String  token,@RequestBody SignupDTO signup) {
        User userData = null;
        try {
        	userData = claimAdjuster.userRegistration(token, signup);
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(userData, "User Registered Successfully"), HttpStatus.OK);
        }catch (Exception e) {
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage(), "Error"), HttpStatus.OK);
		}
    }
}
