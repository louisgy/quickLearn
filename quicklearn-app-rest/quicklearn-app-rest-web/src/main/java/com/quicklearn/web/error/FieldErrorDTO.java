package com.quicklearn.web.error;

import org.springframework.validation.FieldError;

public class FieldErrorDTO {
	
	  private String fieldName;
	  private String message;
	  
	  
	public FieldErrorDTO(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}
	
	  public FieldErrorDTO(FieldError fieldError) {
		    this.fieldName = fieldError.getField();
		    this.message = fieldError.getDefaultMessage();
		  }
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "FieldErrorDTO [fieldName=" + fieldName + ", message=" + message + "]";
	}
	  

}
