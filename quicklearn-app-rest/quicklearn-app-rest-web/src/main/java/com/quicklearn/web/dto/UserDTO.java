package com.quicklearn.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.quicklearn.web.service.PasswordMatchInterface;
import com.quicklearn.web.validator.PasswordMatch;
import com.quicklearn.web.validator.UniqueEmail;
import com.quicklearn.web.validator.ValidPassword;



@PasswordMatch(groups = {com.quicklearn.web.dto.UserDTO.updateUser.class,Default.class})
public class UserDTO implements PasswordMatchInterface {
	
	@Email (groups = {updateUser.class,Default.class})
	@UniqueEmail (groups = updateUser.class)
	private String email;

	@ValidPassword(groups = {updateUser.class,Default.class})
	private String password;
	
	
	private String matchingPassword;
	
	@NotNull(groups = {updateUser.class,Default.class})
	@Size(min = 2, max = 32,groups = {updateUser.class,Default.class})
	private String firstName;
	
	@NotNull(groups = {updateUser.class,Default.class})
	@Size(min = 2, max = 32,groups = {updateUser.class,Default.class})
	private String lastName;
	
	private String role;

	public UserDTO() {
		
	}
	
	public UserDTO(String email, String password, String matchingPassword,
			String firstName, String lastName,
			String role) {
		super();
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public UserDTO(String email, String password, String firstName,
			String lastName, String role) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	public interface updateUser{
		
	}
	

	
	

}
