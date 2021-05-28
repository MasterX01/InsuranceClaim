package com.bl.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
