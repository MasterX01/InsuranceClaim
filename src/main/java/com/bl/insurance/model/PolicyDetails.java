package com.bl.insurance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.bl.insurance.dto.PolicyDetailsDTO;

@Entity
public class PolicyDetails {
	
	@Id
	public Long policyNo;

    public Long accountNumber;
    public double premiumAmount;
    public Long userId;

    @OneToOne
    public ClaimPolicy claimpolicy;
    
    public PolicyDetails() {}
    
    public PolicyDetails(PolicyDetailsDTO policy) {
    	this.accountNumber = policy.getAccountNumber();
    	this.premiumAmount = policy.getPremiumAmount();
    	this.policyNo = policy.getPolicyNumber();
    }
    
    public void setUserId(Long userId) {
		this.userId = userId;
	}
    public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
    public void setPolicyNo(Long policyNo) {
		this.policyNo = policyNo;
	}
    public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
    public void setClaimpolicy(ClaimPolicy claimpolicy) {
		this.claimpolicy = claimpolicy;
	}
    
    public Long getAccountNumber() {
		return accountNumber;
	}
    public ClaimPolicy getClaimpolicy() {
		return claimpolicy;
	}
    public Long getPolicyNo() {
		return policyNo;
	}
    public double getPremiumAmount() {
		return premiumAmount;
	}
    public Long getUserId() {
		return userId;
	}
}
