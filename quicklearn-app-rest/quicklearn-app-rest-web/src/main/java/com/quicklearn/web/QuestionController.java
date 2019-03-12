package com.quicklearn.web;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.domain.Course;
import com.quicklearn.domain.QuestionContent;
import com.quicklearn.web.service.QuestionsProcessing;

@RestController
public class QuestionController {
	
//	Utility utility;

	@Autowired
	QuestionsProcessing questionsProcessing;
	
	@PostMapping("/createQuestion")
	public String addQuestion() throws XMLStreamException { 
		QuestionContent q = new QuestionContent("mult","option",234,"instructions content ","statement instructions",null,"answer");
		QuestionContent a = new QuestionContent("mult","option",234,"instructions content","statement instructions",null,"answer");
		
		List <QuestionContent> questionList =  new ArrayList <QuestionContent>();
		questionList.add(q);
		questionList.add(a);
		questionsProcessing.registerQuestion(questionList, "qt.xml");
		return "ok";
	}
	
	@GetMapping("/readQuestions")
	public String readQuestion() throws XMLStreamException, IOException { 
		List<QuestionContent> questions ;
		questions = questionsProcessing.readQuestions("qt.xml");
		for (QuestionContent element : questions) {
		    System.out.println("id : "+element.getId());
		    System.out.println("category : "+element.getCategory());
		    List<String> s = element.getOptions();
		    System.out.println("\n"+s+"\n");

		    System.out.println("answer : "+element.getAnswer()+"\n");
		    
		}
		

        
		return "ok";
	}
	
	

}
