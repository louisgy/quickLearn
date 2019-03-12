package com.quicklearn.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


public class Answers {
	
	@Id
	@Column(name="ANSWERS_ID")
	private AnswersId id;
	
	@MapsId("testAttemptId")
	@ManyToOne
	@JoinColumn(name="TEST_ATTTEMPT_ID")
	private TestAttempt testAttempt;
	
	@MapsId("questionId")
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@MapsId("userId")
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	private String answers;
	
}
