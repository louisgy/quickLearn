package com.quicklearn.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import com.quicklearn.domain.Pool;



@Entity
@TableGenerator(name="Question_Gen",
table="ID_GEN",
pkColumnName="GEN_NAME",
valueColumnName="GEN_VAL",
pkColumnValue="Quest_Gen",
initialValue=9000,
allocationSize=8)
public class Question {

@Id
@GeneratedValue(generator = "Question_Gen")
private int id;
private int difficultyScore;  // A mumber that indicate the difficulty level of the question

private boolean activated;
@ManyToOne
@JoinColumn(name="pool")
public Pool pool;

@ManyToOne
@JoinColumn(name="testId")
public Test test;

private String questionType; // TOF (True false) FBL (Fill blank), 
							 // SMO (select more than one) SOO (select only one)
		                     // 

public int getDifficultyScore() {
	return difficultyScore;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void setDifficultyScore(int difficultyScore) {
	this.difficultyScore = difficultyScore;
}

public boolean isActivated() {
	return activated;
}

public void setActivated(boolean activated) {
	this.activated = activated;
}

public Pool getPool() {
	return pool;
}

public void setPool(Pool pool) {
	this.pool = pool;
}

public Test getTest() {
	return test;
}

public void setTest(Test test) {
	this.test = test;
}

public String getQuestionType() {
	return questionType;
}

public void setQuestionType(String questionType) {
	this.questionType = questionType;
}



}
