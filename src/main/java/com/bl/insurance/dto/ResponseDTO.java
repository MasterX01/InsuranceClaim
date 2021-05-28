package com.bl.insurance.dto;

public class ResponseDTO {
	Object obj;
	String message;
	
	public ResponseDTO(Object obj, String message) {
		this.obj = obj;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public Object getObj() {
		return obj;
	}
}
