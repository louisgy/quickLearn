package com.quicklearn.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.domain.Course;
import com.quicklearn.domain.QuestionContent;
import com.quicklearn.web.service.QuestionsProcessing;

@RestController
public class QuestionController {



	@Autowired
	QuestionsProcessing questionsProcessing;

	@PostMapping("/addQuestions")
	public String addQuestions() throws XMLStreamException, IOException {
		QuestionContent q = new QuestionContent("mult",453,"instructions content ","statement instructions",null,"answer");
		QuestionContent a = new QuestionContent("mult",234,"instructions content","statement instructions",null,"answer");
		List <QuestionContent> questions = new ArrayList<QuestionContent>();
		questions.add(q);
		questions.add(a);
		//questionsProcessing.registerQuestions("qx.xml", questions);
		questionsProcessing.regQuestions("qx.xml", questions);
		return "ok";
	}
 
	@GetMapping("/readQuestions")
	public ResponseEntity<List<QuestionContent>> readQuestion(
			@RequestParam(value = "selection", defaultValue = "920,284") int[] selection)
			throws XMLStreamException, IOException {
		List<QuestionContent> questions;
		int questionsRequested[] = selection;
		questions = questionsProcessing.readAllQuestions("qt.xml", questionsRequested);

		if (!questions.isEmpty()) {
			return ResponseEntity.ok().body(questions);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	


}
