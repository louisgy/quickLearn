package com.quicklearn.web.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.quicklearn.web.validator.CourseSessionExistence;
import com.quicklearn.web.validator.DateOrdering;
import com.quicklearn.web.validator.StudentExistence;

@DateOrdering
public class EnrollmentDTO {
	
	@NotNull
	private Date enrolledDate;
	
	private boolean isComplete;
	
	@NotNull
	private long grade;
	
	@NotNull
	@StudentExistence
	private int userId;
	
	@NotNull
	@CourseSessionExistence
	private int courseSessionId;
	
	public EnrollmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getEnrolledDate() {
		return enrolledDate;
	}

	public void setEnrolledDate(Date enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public long getGrade() {
		return grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCourseSessionId() {
		return courseSessionId;
	}

	public void setCourseSessionId(int courseSessionId) {
		this.courseSessionId = courseSessionId;
	}
	
	

}
