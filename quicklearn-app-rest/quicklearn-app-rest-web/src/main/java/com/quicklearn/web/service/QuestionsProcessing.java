package com.quicklearn.web.service;

import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;

import com.quicklearn.domain.QuestionContent;

public interface QuestionsProcessing {
	public List<QuestionContent> getQuestions(int questionsRequested[]) throws JDOMException, IOException;

}
