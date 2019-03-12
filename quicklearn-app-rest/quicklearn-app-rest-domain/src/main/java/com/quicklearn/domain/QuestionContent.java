package com.quicklearn.domain;

import java.util.ArrayList;
import java.util.List;

public class QuestionContent {
	private String category;
	private String option;
	private int id;
	private String instructions;
	private String statement;
	private List <String> options;
	private String answer;
	
	public static final String
		ID="id",
		INSTRUCTIONS="instructions",
		STATEMENT="statement",
		OPTION="option",
		ANSWER="answer",
		CATEGORY="category";
	
	
	public QuestionContent(String categorie, String option, int id, String instructions, String statement,
			List<String> options, String answer) {
		super();
		this.category = category;
		this.option = option;
		this.id = id;
		this.instructions = instructions;
		this.statement = statement;
		this.options = options;
		this.answer = answer;
	}
	

	
	public QuestionContent() {
		this.options =  new ArrayList<>();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.options.add(option);
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
