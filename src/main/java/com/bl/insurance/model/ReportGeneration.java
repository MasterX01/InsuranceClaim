package com.bl.insurance.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ReportGeneration {

	@Id
	private Long claimNo;
	private String claimReason;
	private String claimType;

	@OneToOne(cascade = CascadeType.ALL)
	private User details;

	public void setClaimNo(Long claimNo) {
		this.claimNo = claimNo;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public void setDetails(User details) {
		this.details = details;
	}
	
	public Long getClaimNo() {
		return claimNo;
	}
	public String getClaimReason() {
		return claimReason;
	}
	public String getClaimType() {
		return claimType;
	}
	public User getDetails() {
		return details;
	}
}
