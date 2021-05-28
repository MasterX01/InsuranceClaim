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
		this.password = signup.password;
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
}
