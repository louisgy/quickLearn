package com.quicklearn.web.dto;

import java.util.Date;
import com.quicklearn.web.service.DateOrderingInterface;
import com.quicklearn.web.validator.CourseExistence;
import com.quicklearn.web.validator.DateOrdering;
import com.quicklearn.web.validator.TeacherExistence;

import javax.validation.constraints.NotNull;

@DateOrdering
public class CourseSessionDTO implements DateOrderingInterface{	
	
	@NotNull
	private Date dateStart;
	
	
	@NotNull
	private Date dateEnd;
	
	@NotNull
	private long averageGrade;
	
	@NotNull
	@TeacherExistence
	private int userId;
	
	@CourseExistence
	@NotNull
	private int courseId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public long getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(long averageGrade) {
		this.averageGrade = averageGrade;
	}
	
	
	
}
