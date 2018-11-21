package com.blueharvest.model;

public class ErrorResponse extends Exception {
	

	private String message;
	
	
	
	

	public ErrorResponse(String str) {
		super();
		this.message=str;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
