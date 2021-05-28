package com.bl.insurance.dto;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class PolicyDetailsDTO {

	@Min(value = 100000, message = "Policy Number must have atleast 6 digits")
	private Long policyNumber;

	@Min(value = 100000, message = "Account Number must have atleast 6 digits")
	private Long accountNumber;

	private double premiumAmount;
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public Long getPolicyNumber() {
		return policyNumber;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}

}
