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

}
