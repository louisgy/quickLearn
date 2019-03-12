package com.quicklearn.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "User_Gen", 
table = "ID_GEN", pkColumnName = "GEN_NAME", 
valueColumnName = "GEN_VAL", 
pkColumnValue = "Usr_Gen", 
initialValue = 50000, 
allocationSize = 6)
public class User {
	
	@Id
	@GeneratedValue(generator = "User_Gen")
	private int id;

	private String email;

	private String password;

	private String firstName;
	
	private String lastName;
	
	private String role;
	
	@OneToMany(mappedBy="user")
	private Collection<Address> address;
	
	@OneToMany(mappedBy="user")
	private Collection<CourseSession> courseSession;
	


	public User() {
	}
	
	public User(String email, String password, String firstName, String lastName, String role) {
	
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
