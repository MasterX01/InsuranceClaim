package com.bl.insurance.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bl.insurance.dto.SignupDTO;

@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	public String username;
	public String password;
	public String roleId;
	
	@OneToMany(cascade = CascadeType.ALL)
	public List<PolicyDetails> policyDetails;
	
	public User() {}
	
	public User(SignupDTO signup) {
		this.username = signup.username;
		this.roleId = signup.roleId;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRoleId() {
		return roleId;
	}
	public Long getUserId() {
		return userId;
	}
	public List<PolicyDetails> getPolicyDetails() {
		return policyDetails;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPolicyDetails(List<PolicyDetails> policyDetails) {
		this.policyDetails = policyDetails;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
