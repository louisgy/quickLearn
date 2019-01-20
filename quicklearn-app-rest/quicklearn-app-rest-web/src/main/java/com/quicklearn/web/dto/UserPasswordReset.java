package com.quicklearn.web.dto;

import javax.validation.constraints.Email;

import com.quicklearn.web.service.PasswordMatchInterface;
import com.quicklearn.web.service.UserValidationInterface;
import com.quicklearn.web.validator.CredentialsAuthenticationReset;
import com.quicklearn.web.validator.ValidPassword;

@CredentialsAuthenticationReset
//@PasswordMatch
public class UserPasswordReset implements PasswordMatchInterface,UserValidationInterface {
	@Email
	private String email;
	private String oldPassword;
	
	

	@ValidPassword
	private String password;
	
	private String   matchingPassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
}
