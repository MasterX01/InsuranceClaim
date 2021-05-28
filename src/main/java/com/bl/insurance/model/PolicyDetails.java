package com.bl.insurance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PolicyDetails {
	
	@Id
	public Long policyNo;

    public Long accountNumber;
    public double premiumAmount;
    public Long userId;

    @OneToOne
    public ClaimPolicy claimpolicy;
}
