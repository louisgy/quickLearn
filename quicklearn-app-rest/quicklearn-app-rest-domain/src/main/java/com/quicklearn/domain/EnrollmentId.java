package com.quicklearn.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class EnrollmentId implements Serializable {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int studentId;
	
	private int courseSessionId;
	
	
	public EnrollmentId() {
		super();
	}

	public EnrollmentId(int studentId, int courseSessionId) {
		super();
		this.studentId = studentId;
		this.courseSessionId = courseSessionId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public int getCourseSessionId() {
		return courseSessionId;
	}
	
	public void setCourseSessionId(int courseSessionId) {
		this.courseSessionId = courseSessionId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseSessionId;
		result = prime * result + studentId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnrollmentId other = (EnrollmentId) obj;
		if (courseSessionId != other.courseSessionId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
	
	
}
