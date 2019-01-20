package com.quicklearn.web.dto;

import javax.validation.constraints.Email;

import com.quicklearn.web.service.UserValidationInterface;
import com.quicklearn.web.validator.CredentialMatches;
import com.quicklearn.web.validator.CredentialsAuthentication;

//@CredentialMatches
@CredentialsAuthentication
public class UserLoginDTO implements UserValidationInterface{
	
	@Email
	private String email;
	
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getMatchingPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getOldPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
