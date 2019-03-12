package com.quicklearn.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;



@Entity
@TableGenerator(name="Opportunity_Gen",
table="ID_GEN",
pkColumnName="GEN_NAME",
valueColumnName="GEN_VAL",
pkColumnValue="opport_Gen",
initialValue=9000,
allocationSize=7)
@Table(name ="TEST_OPPORTUNITY")

public class TestOpportunity {

@Id
@GeneratedValue(generator = "Opportunity_Gen")
private int testOpportunityId;

	private int maxStudents;

	private long averageGrade;

	private Date dateStartAllowed;

	private Date dateEndAllowed;



	private boolean isActive;

	private int maxAttemptAllowed;

	@ManyToOne
	@JoinColumn(name="courseSessionId")
	public CourseSession courseSession;

	@ManyToOne
	@JoinColumn(name="testId")
	public Test test;
	
	@OneToMany(mappedBy="testOpportunity")
	private Collection<TestAttempt> testAttempt;

	

	public TestOpportunity() {
		super();
	}

	public TestOpportunity(int maxStudents, long averageGrade, Date dateStartAllowed, Date dateEndAllowed,
			 boolean isActive, int maxAttemptAllowed, CourseSession courseSession, Test test) {
		super();
		this.maxStudents = maxStudents;
		this.averageGrade = averageGrade;
		this.dateStartAllowed = dateStartAllowed;
		this.dateEndAllowed = dateEndAllowed;
		this.isActive = isActive;
		this.maxAttemptAllowed = maxAttemptAllowed;
		this.courseSession = courseSession;
		this.test = test;

	}

	public int getTestOpportunityId() {
		return testOpportunityId;
	}

	public void setTestOpportunityId(int testOpportunityId) {
		this.testOpportunityId = testOpportunityId;
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
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getMaxAttemptAllowed() {
		return maxAttemptAllowed;
	}

	public void setMaxAttemptAllowed(int maxAttemptAllowed) {
		this.maxAttemptAllowed = maxAttemptAllowed;
	}

	public CourseSession getCourseSession() {
		return courseSession;
	}

	public void setCourseSession(CourseSession courseSession) {
		this.courseSession = courseSession;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Collection<TestAttempt> getTestAttempt() {
		return testAttempt;
	}

	public void setTestAttempt(Collection<TestAttempt> testAttempt) {
		this.testAttempt = testAttempt;
	}
	
	


}
