package com.quicklearn.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


import org.springframework.stereotype.Component;

@Component
@Entity
public class Enrollment {

	@Id
	@Column(name = "ENROLLEMENT_ID")
	private EnrollmentId id;

	private Date enrolledDate;
	private long grade;
	private boolean isComplete;

	public Enrollment() {
		super();
	}

	public Enrollment(EnrollmentId id, Date enrolledDate, long grade, boolean isComplete, User user,
			CourseSession courseSession) {
		super();
		this.id = id;
		this.enrolledDate = enrolledDate;
		this.grade = grade;
		this.isComplete = isComplete;
		this.user = user;
		this.courseSession = courseSession;
	}

	@MapsId("userId")
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@MapsId("courseSessionId")
	@ManyToOne
	@JoinColumn(name="COURSE_SESSION_ID")
	private CourseSession courseSession;

	public EnrollmentId getId() {
		return id;
	}

	public void setId(EnrollmentId id) {
		this.id = id;
	}

	public Date getEnrolledDate() {
		return enrolledDate;
	}

	public void setEnrolledDate(Date enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

	public long getGrade() {
		return grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CourseSession getCourseSession() {
		return courseSession;
	}

	public void setCourseSession(CourseSession courseSession) {
		this.courseSession = courseSession;
	}

	@Override
	public String toString() {
		return "Enrollment [enrolledDate=" + enrolledDate + ", grade=" + grade + ", isComplete=" + isComplete
				+ ", user=" + user + ", courseSession=" + courseSession + "]";
	}

	
	

}
