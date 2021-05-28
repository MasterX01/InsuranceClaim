package com.bl.insurance.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ClaimPolicyDTO {

	@NotEmpty(message = "Claim Reason cannot be empty")
	private String claimReason;

	@NotEmpty(message = "Accident Location cannot be empty")
	private String accidentLocation;

	@NotEmpty(message = "Accident City cannot be empty")
	private String accidentCity;

	@NotEmpty(message = "Accident State cannot be empty")
	private String accidentState;

	@NotEmpty(message = "Accident Zip cannot be empty")
	@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Invalid ZipCode")
	private String accidentZip;

	@NotEmpty(message = "Claim Type cannot be empty")
	private String claimType;

	
	public String getAccidentCity() {
		return accidentCity;
	}
	public String getAccidentLocation() {
		return accidentLocation;
	}
	public String getAccidentState() {
		return accidentState;
	}
	public String getAccidentZip() {
		return accidentZip;
	}
	public String getClaimReason() {
		return claimReason;
	}
	public String getClaimType() {
		return claimType;
	}
}
