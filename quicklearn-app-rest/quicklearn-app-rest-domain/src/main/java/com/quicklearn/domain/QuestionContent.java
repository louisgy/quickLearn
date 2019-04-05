package com.quicklearn.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuestionContent {
	
	private String category;

	private int id;
	private String instructions;
	private String statement;
	private List <String [][]> options;

	
	public static final String
		ID="id",
		INSTRUCTIONS="instructions",
		STATEMENT="statement",
		OPTION="option",
		ANSWER="ans",
		CATEGORY="category";
	    
	
	public QuestionContent() {
		options = new ArrayList<String [][]>() ;
	}
	
	public QuestionContent(String category, int id, String instructions, String statement, List<String[][]> options,
			String answer) {
		super();
		this.category = category;
		this.id = id;
		this.instructions = instructions;
		this.statement = statement;
		this.options = options;

	}

	public void addOptions(String option[][]) {
		this.options.add(option);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<String[][]> getOptions() {
		return options;
	}

	public void setOptions(List<String[][]> options) {
		this.options = options;
	}


	
}
