package com.quicklearn.domain;



public class AnswersId {
	
	private int testAttemptId;
	private int questionId;
	private int studentId;
	
	public AnswersId(int testAttemptId, int questionId, int studentId) {
		super();
		this.testAttemptId = testAttemptId;
		this.questionId = questionId;
		this.studentId = studentId;
	}
	


}
