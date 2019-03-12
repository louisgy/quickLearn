package com.quicklearn.web.dto;

import java.time.Duration;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.quicklearn.web.service.DateOrderingInterface;
import com.quicklearn.web.validator.CourseExistence;
import com.quicklearn.web.validator.DateOrdering;

@DateOrdering
public class TestDTO implements DateOrderingInterface{
	
	@NotNull
	private Date datePublished;
	@NotNull
	private Date dateAvailabilityStart;
	@NotNull
	private Date dateAvailabilityEnd;
	@NotNull
	private boolean availabilityStatus;
	@NotNull
	private String weight; // ADVNC, BSIC, AVG
	@NotNull
	private int duration;
	@NotNull
	@CourseExistence
	private int CourseId;
	
	
	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	@Override
	public Date getDateStart() {
		// TODO Auto-generated method stub
		return dateAvailabilityStart;
	}
	
	@Override
	public Date getDateEnd() {
		// TODO Auto-generated method stub
		return dateAvailabilityEnd;
	}
	
	public Date getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
	public Date getDateAvailabilityStart() {
		return dateAvailabilityStart;
	}
	public void setDateAvailabilityStart(Date dateAvailabilityStart) {
		this.dateAvailabilityStart = dateAvailabilityStart;
	}
	public Date getDateAvailabilityEnd() {
		return dateAvailabilityEnd;
	}
	public void setDateAvailabilityEnd(Date dateAvailabilityEnd) {
		this.dateAvailabilityEnd = dateAvailabilityEnd;
	}
	public boolean isAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	

}
