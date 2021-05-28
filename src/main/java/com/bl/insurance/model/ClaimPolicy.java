package com.bl.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bl.insurance.dto.ClaimPolicyDTO;

@Entity
public class ClaimPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long claimNumber;

	private Long policyNumber;
    private String claimReason;
    private String accidentLocation;
    private String accidentCity;
    private String accidentState;
    private String accidentZip;
    private String claimType;
    
	public ClaimPolicy(ClaimPolicyDTO claimPolicyDTO) {
		this.claimReason = claimPolicyDTO.getClaimReason();
        this.accidentLocation = claimPolicyDTO.getAccidentLocation();
        this.accidentCity = claimPolicyDTO.getAccidentCity();
        this.accidentState = claimPolicyDTO.getAccidentState();
        this.accidentZip = claimPolicyDTO.getAccidentZip();
        this.claimType = claimPolicyDTO.getClaimType();
	}
	
	public void setPolicyNumber(Long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public void setAccidentCity(String accidentCity) {
		this.accidentCity = accidentCity;
	}
	public void setAccidentLocation(String accidentLocation) {
		this.accidentLocation = accidentLocation;
	}
	public void setAccidentState(String accidentState) {
		this.accidentState = accidentState;
	}
	public void setAccidentZip(String accidentZip) {
		this.accidentZip = accidentZip;
	}
	public void setClaimNumber(Long claimNumber) {
		this.claimNumber = claimNumber;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	
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
    public Long getClaimNumber() {
		return claimNumber;
	}
    public String getClaimReason() {
		return claimReason;
	}
    public String getClaimType() {
		return claimType;
	}
    public Long getPolicyNumber() {
		return policyNumber;
	}
}
