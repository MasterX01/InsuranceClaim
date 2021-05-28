package com.bl.insurance.dto;

public class LoginSuccess {
	
	public String message;
	public String token;
//	public Object obj;
	
	public LoginSuccess() {}
	
	public LoginSuccess(String message, String token) { //, Object obj
		this.message = message;
		this.token = token;
//		this.obj = obj;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	
//	public void setObj(Object obj) {
//		this.obj = obj;
//	}
//	public Object getObj() {
//		return obj;
//	}

}
