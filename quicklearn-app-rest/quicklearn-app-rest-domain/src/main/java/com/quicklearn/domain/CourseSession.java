package com.quicklearn.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="COURSE_SESSION")
public class CourseSession {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COURSE_SESSION_ID")
    private int id;
	private Date dateStart;
	private Date dateEnd;
	private double averageGrade;	
	
	public CourseSession() {
		super();
	}
	
	public CourseSession(Date dateStart, Date dateEnd, double averageGrade, Course course, User user) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.averageGrade = averageGrade;
		this.course = course;
		this.user = user;
	}



	@ManyToOne
	  @JoinColumn(name="courseId")
	private Course course;
	
	@ManyToOne 
	  @JoinColumn(name="userId")
	private User user;
	

	
	@OneToMany(mappedBy="courseSession")
	private Collection<TestOpportunity> testOpportunity;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}





   

}
