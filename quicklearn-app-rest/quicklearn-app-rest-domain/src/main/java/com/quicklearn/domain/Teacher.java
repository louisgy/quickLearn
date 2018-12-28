package com.quicklearn.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Teacher {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	private String email;
	private String firstName;
	private String lastName;
	private Date dob;
	private String username;
	
	@OneToMany(mappedBy="teacher")
	private Collection<CourseSession> courseSession;
	
	private Teacher(){
		courseSession = new ArrayList<CourseSession>();
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Collection<CourseSession> getCourseSession() {
		return courseSession;
	}
}
