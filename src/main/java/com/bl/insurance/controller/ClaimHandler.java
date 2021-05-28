package com.bl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bl.insurance.dto.ResponseDTO;
import com.bl.insurance.model.ReportGeneration;
import com.bl.insurance.model.User;
import com.bl.insurance.service.ClaimHandlerService;

@RestController
@RequestMapping("/claimhandler")
public class ClaimHandler {

	@Autowired
	private ClaimHandlerService claimHandlerService;
	
	@GetMapping("/ReportGeneration")
    public  ResponseEntity<ResponseDTO> GenerateReport(@RequestHeader("Authorization") String token,@RequestParam("policyNumber") Long policyNumber,@RequestParam("claimNumber") Long claimNumber) {
        try {
        	ReportGeneration reportGeneration = claimHandlerService.generateReport(token,policyNumber,claimNumber);
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(reportGeneration, "Report Generated Successfully"), HttpStatus.OK);
        }catch (Exception e) {
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage(), "Error"), HttpStatus.BAD_REQUEST);
		}
    }

    @GetMapping("/userdetails")
    public ResponseEntity<ResponseDTO> getUserDetails(@RequestHeader("Authorization") String token,@RequestParam("policyNumber") Long policyNumber,@RequestParam("claimNumber") Long claimNumber){
        try{
        	User userData = claimHandlerService.userDetails(token,policyNumber,claimNumber);
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(userData, "Operation Successfull"), HttpStatus.OK);
        }catch (Exception e) {
        	return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage(), "Error"), HttpStatus.BAD_REQUEST);
		}
    }

}
