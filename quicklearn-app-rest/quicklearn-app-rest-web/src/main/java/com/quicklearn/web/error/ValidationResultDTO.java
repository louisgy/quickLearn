package com.quicklearn.web.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



public class ValidationResultDTO {

	private List<FieldErrorDTO> fieldErrors;
	
	private List<GlobalErrorDTO> globalErrors;
	
	 public ValidationResultDTO() {
		    fieldErrors = new ArrayList<>();
		    globalErrors = new ArrayList<>();
		  }
	
	public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}
	
	public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
		 if (fieldErrors != null) 
		this.fieldErrors = fieldErrors;
	}
	
	public List<GlobalErrorDTO> getGlobalErrors() {
		return globalErrors;
	}
	
	public void setGlobalErrors(List<GlobalErrorDTO> globalErrors) {
		 if (globalErrors != null) 
		this.globalErrors = globalErrors;
	}
	
	public void addGlobalError(String message) {
		GlobalErrorDTO globalErrorDto = new GlobalErrorDTO(message);
	    globalErrors.add(globalErrorDto);
	  }
	
	
	
}
