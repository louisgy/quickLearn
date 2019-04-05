package com.quicklearn.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.domain.Course;
import com.quicklearn.domain.QuestionContent;
import com.quicklearn.web.Impl.QuestionsProcessingImpl;
import com.quicklearn.web.service.QuestionsProcessing;
import com.quicklearn.web.service.QuestionsProcessingFast;

@RestController
public class QuestionController {



	@Autowired
	QuestionsProcessingFast questionsProcessingFast;
	@Autowired
	QuestionsProcessingImpl questionsProcessingImpl;

	@PostMapping("/addQuestions")
	public String addQuestions() throws XMLStreamException, IOException, JDOMException {
		QuestionContent q = new QuestionContent("mult",453,"instructions content ","statement instructions",null,"answer");
		QuestionContent a = new QuestionContent("mult",234,"instructions content","statement instructions",null,"answer");
		List <QuestionContent> questions = new ArrayList<QuestionContent>();
		questions.add(q);
		questions.add(a);
	//	questionsProcessing.addQuestions("qx.xml", questions);
		//questionsProcessing.registerQuestions("qx.xml", questions);
		//questionsProcessing.regQuestions("qx.xml", questions);
		int i [] = {1,2};
		//questionsProcessingImpl.getQuestions(i );
		return "ok";
	}
 
	@GetMapping("/getQuestions")
	public ResponseEntity<List<QuestionContent>> readQuestion(
			@RequestParam(value = "selection", defaultValue = "920,284") int[] selection)
			throws XMLStreamException, IOException, JDOMException {
		List<QuestionContent> questions;
		int questionsRequested[] = selection;
		//questions = questionsProcessingFast.readAllQuestions("qt.xml", questionsRequested);
		int i [] = {1,2};
		questions = questionsProcessingImpl.getQuestions(i);
		if (!questions.isEmpty()) {
			return ResponseEntity.ok().body(questions);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	


}
