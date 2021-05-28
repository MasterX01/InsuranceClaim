package com.bl.insurance.dto;

public class DecodedToken {

	Long userId;
	String role;
	
	public DecodedToken() {	}
	
	public DecodedToken(Long userId, String role) {
		this.userId = userId;
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	public Long getUserId() {
		return userId;
	}
}
