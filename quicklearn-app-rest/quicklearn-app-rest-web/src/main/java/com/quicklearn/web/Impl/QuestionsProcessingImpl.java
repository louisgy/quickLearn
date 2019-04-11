package com.quicklearn.web.Impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.QuestionContent;
import com.quicklearn.web.service.QuestionsProcessing;

import java.io.File;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Content;
import org.jdom2.Content.CType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;

@Component
public class QuestionsProcessingImpl implements QuestionsProcessing {

//	@Value("${fileName}")
//	private String fileName;
	private String fileName = "qx.xml";

	File file = new File(fileName);

	@Override
	public List<QuestionContent> getQuestions(int[] questionsRequested) throws JDOMException, IOException {
		List<QuestionContent> questionList = new ArrayList<QuestionContent>();
		List<String[][]> allOptions;
		SAXBuilder builder = new SAXBuilder();
		Document document = (Document) builder.build(file);
		Element rootNode = document.getRootElement();

		List<Element> listElement = rootNode.getChildren("question");

		for (Element e : listElement) {
			QuestionContent q = new QuestionContent();
			List<Element> children = e.getChildren();
			allOptions = new ArrayList<String[][]>();

			q.setCategory(e.getAttributeValue("category"));
			q.setId(Integer.parseInt(e.getAttributeValue("id")));
			q.setInstructions(e.getChildText("instructions"));
			q.setStatement(e.getChildText("statement"));
			q.setExplanation(e.getChildText("explanation"));

			List<Element> level3Element = e.getChild("options").getChildren();

			String option[][] = new String[2][level3Element.size()];

			for (Element child : level3Element) {
				option[0][level3Element.indexOf(child)] = child.getAttributeValue("ans");
				option[1][level3Element.indexOf(child)] = child.getText();
			}
			allOptions.add(option);
			q.setOptions(allOptions);
			questionList.add(q);
		}
		return questionList;
	}

	public boolean addQuestion(QuestionContent q) throws JDOMException, IOException {
		
		SAXBuilder builder = new SAXBuilder();
		Document document = (Document) builder.build(file);
		Element rootNode = document.getRootElement();
		
		QuestionContent question = new QuestionContent();
		List <String[][] > options = new ArrayList<>();
		String [][] s = new String [2][4];
		
		s[0][0]= "t";
		s[1][1]= "text 0";
		options.add(s);
		
		s[0][0]= "t";
		s[1][1]= "text 1";
		options.add(s);
		
		
		s[0][0]= "t";
		s[1][1]= "text 2";
		options.add(s);
		
		
		s[0][0]= "f";
		s[1][1]= "text 3";
		options.add(s);
		

		question.setId(800);
		question.setCategory("mult");
		question.setExplanation("Explanation ....");
		question.setInstructions("Instructions ...");
		question.setStatement("Statement ...");
		question.setOptions(options);
		
		Element  element = new Element("question");
		element.setAttribute("category", question.getCategory());
		element.setAttribute("id", Integer.toString(question.getId()));
		
		return false;
	}

	public boolean removeQuestion() throws JDOMException, IOException {
		boolean isRemoved = false;
		SAXBuilder builder = new SAXBuilder();
		Document document = (Document) builder.build(file);
		Element rootNode = document.getRootElement();

		List<Element> listElement = rootNode.getChildren("question");

		for (Element e : listElement) {
			if (Integer.parseInt(e.getAttributeValue("id")) == 435) {
				e.getParent().removeContent(e);
				break;
			}
		}
		if (isRemoved) {
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			xmlOutputter.output(document, new FileOutputStream(fileName));
			return true;
		}

		return false;
	}

}
