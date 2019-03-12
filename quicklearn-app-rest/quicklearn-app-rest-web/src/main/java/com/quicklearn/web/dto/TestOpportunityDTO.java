package com.quicklearn.web.dto;

import java.util.Date;




public class TestOpportunityDTO {
	
	private int  maxStudents;
	private long averageGrade;
	private Date dateStartAllowed;
	private Date dateEndAllowed;
	private boolean active;

	private int maxAttemptAllowed;
	
	private int courseSessionId;
	private int testId;
	
	public int getCourseSessionId() {
		return courseSessionId;
	}

	public void setCourseSessionId(int courseSessionId) {
		this.courseSessionId = courseSessionId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public long getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(long averageGrade) {
		this.averageGrade = averageGrade;
	}

	public Date getDateStartAllowed() {
		return dateStartAllowed;
	}

	public void setDateStartAllowed(Date dateStartAllowed) {
		this.dateStartAllowed = dateStartAllowed;
	}

	public Date getDateEndAllowed() {
		return dateEndAllowed;
	}

	public void setDateEndAllowed(Date dateEndAllowed) {
		this.dateEndAllowed = dateEndAllowed;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getMaxAttemptAllowed() {
		return maxAttemptAllowed;
	}

	public void setMaxAttemptAllowed(int maxAttemptAllowed) {
		this.maxAttemptAllowed = maxAttemptAllowed;
	}
	
	
	
}
