package com.quicklearn.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;



@Table(name ="STUDENT_GROUP")
public class StudentGroup {
	@Id
	@Column(name="STUDENT_GROUP_ID")
    private studentGroupId id;
	
	@MapsId("testOpportunity_id")
	@ManyToOne
	@JoinColumn(name="TEST_OPPORTUNITY_ID")
	private TestOpportunity testOpportunity;
	
	@MapsId("userId")
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	
	private long averageGrade;

}
