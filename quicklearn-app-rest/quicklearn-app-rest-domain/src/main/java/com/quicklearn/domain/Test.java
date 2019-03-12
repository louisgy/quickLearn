package com.quicklearn.domain;

import java.time.Duration;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;




@Entity
@TableGenerator(name = "Test_Gen", 
table = "ID_GEN", pkColumnName = "GEN_NAME", 
valueColumnName = "GEN_VAL", 
pkColumnValue = "Test_Gen", 
initialValue = 10000, 
allocationSize = 5)
public class Test {
	@Id
	@GeneratedValue(generator = "Test_Gen")
	private int id;
	
	private Date DatePublished;
	private Date dateAvailabilityStart;
	private Date dateAvailabilityEnd;
	private boolean availabilityStatus;
	private String weight;
	private int duration;
	//private int weightScore;
//	@MapsId("courseId")
	@ManyToOne
	  @JoinColumn(name="courseId")
	private Course course;
	
	@OneToMany(mappedBy="test")
	private Collection<TestOpportunity> testOpportunity;
	
	@OneToMany(mappedBy="test")
	private Collection<Question> question;
	
	

	public Test() {

	}



	public Test(Date datePublished, Date dateAvailabilityStart, Date dateAvailabilityEnd, boolean availabilityStatus,
			String weight, int duration, Course course) {

		DatePublished = datePublished;
		this.dateAvailabilityStart = dateAvailabilityStart;
		this.dateAvailabilityEnd = dateAvailabilityEnd;
		this.availabilityStatus = availabilityStatus;
		this.weight = weight;
		this.duration = duration;
		this.course = course;
	}



	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDatePublished() {
		return DatePublished;
	}
	public void setDatePublished(Date datePublished) {
		DatePublished = datePublished;
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
