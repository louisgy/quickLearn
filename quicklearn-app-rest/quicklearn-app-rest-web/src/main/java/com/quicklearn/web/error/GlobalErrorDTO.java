package com.quicklearn.web.error;

public class GlobalErrorDTO {
	
	private String message;
	
	

	public GlobalErrorDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GlobalErrorDTO [message=" + message + "]";
	}
	

}
