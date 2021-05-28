package com.bl.insurance.service;

import com.bl.insurance.model.ReportGeneration;
import com.bl.insurance.model.User;

public interface IClaimHandlerService {
	ReportGeneration generateReport(String token, Long policyNumber, Long claimNumber);

	User userDetails(String token, Long policyNumber, Long claimNumber);
}
