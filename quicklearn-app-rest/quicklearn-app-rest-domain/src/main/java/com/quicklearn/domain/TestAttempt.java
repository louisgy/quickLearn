package com.quicklearn.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="TestAttempt_Gen",
table="ID_GEN",
pkColumnName="GEN_NAME",
valueColumnName="GEN_VAL",
pkColumnValue="TstAttpt_Gen",
initialValue=9000,
allocationSize=8)
@Table(name ="TEST_ATTEMPT")
public class TestAttempt {
	@Id
	@GeneratedValue(generator = "TestAttempt_Gen")
	private int testAttemptId;
	private Date dateStart;
	private Date dateEnd;
	private boolean isCompleted;
	private int  testOpportunityId; // unique and automatic
	private long gradeAverage;
	
	@ManyToOne
	  @JoinColumn(name="testOpportunity")
	private TestOpportunity testOpportunity;

}
