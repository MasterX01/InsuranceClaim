package com.bl.insurance.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class SignupDTO {
	 
	@NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "UserName must start with uppercase and must have more then three characters")
	public String username;
	
	@NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}", 
    		message = "Password must be 8 characters,one uppercase,one lowercase,aleast one number and one special character")
	public String password;
	
	@NotEmpty
	@Pattern(regexp = "Insured|ClaimHandler|ClaimAdjuster", message = "Role Code needs to be either Insured or ClaimHandler or ClaimAdjuster")
	public String roleId;
	
	public String getPassword() {
		return password;
	}
	public String getRoleId() {
		return roleId;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
