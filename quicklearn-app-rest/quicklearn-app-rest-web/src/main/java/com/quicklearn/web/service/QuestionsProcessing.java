package com.quicklearn.web.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.XMLEvent;

import org.springframework.stereotype.Component;


import com.quicklearn.domain.QuestionContent;
 

@Component
public class QuestionsProcessing {

	public List<QuestionContent> readQuestions(String filename) throws FileNotFoundException, XMLStreamException {
		List<QuestionContent> data = new ArrayList<>();
		QuestionContent question = new QuestionContent();
		
		Reader reader = new FileReader(filename);
		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
		XMLStreamReader xmlInputReader = xmlInputFactory.createXMLStreamReader(reader);

		while (xmlInputReader.hasNext()) {
			int eventType = xmlInputReader.next();
			if (xmlInputReader.getEventType() == XMLEvent.START_ELEMENT) {
				String elementName = xmlInputReader.getName().toString();
//				System.out.println("\n\n" + "Element Name : " + elementName + "\n\n");
				switch (elementName) {
				case "question":
					
					question = new QuestionContent();
					data.add(question);
					question.setId(Integer.parseInt(xmlInputReader.getAttributeValue("", QuestionContent.ID)));
					question.setCategory(xmlInputReader.getAttributeValue("", QuestionContent.CATEGORY));
					break;
				case QuestionContent.OPTION:
					question.setOption(xmlInputReader.getElementText());
					break;
				case QuestionContent.CATEGORY:
					question.setCategory(xmlInputReader.getElementText());
					break;
				case QuestionContent.ANSWER:
					question.setAnswer(xmlInputReader.getElementText());
				default:
					break;
				}
			}

		}
		return data;
	}

	public void registerQuestion(List<QuestionContent> data, String filename) throws XMLStreamException {

		XMLOutputFactory factory = XMLOutputFactory.newInstance();

		StringWriter sw = new StringWriter();
		XMLStreamWriter writer = factory.createXMLStreamWriter(sw);

//		IndentingXMLStreamWriter writer = new IndentingXMLStreamWriter(w);

		writer.writeStartDocument();
		writer.writeStartElement("questions");

		for (QuestionContent questionContent : data) {
			createQuestionElement(writer, questionContent);
			System.out.println("\n\n" + "IT REALLY HAPPEN *********************");
			System.out.println("Instructions :" + questionContent.getInstructions());
			System.out.println("Statement :" + questionContent.getStatement());
		}

		writer.writeEndElement();
		writer.writeEndDocument();

		writer.flush();
		writer.close();
	}

	private void updateQuestion(int questionId) {

	}

	private void removeQuestion(int questionId) {

	}

	private QuestionContent findQuestions(List<Integer> id) {

		return null;
	}

	private void createQuestionElement(XMLStreamWriter writer, QuestionContent questionContent)
			throws XMLStreamException {
		writer.writeStartElement("question");
		writer.writeAttribute(QuestionContent.ID, Integer.toString(questionContent.getId()));
		writeDataElement(writer, questionContent.getInstructions(), QuestionContent.INSTRUCTIONS);
		writer.writeEndElement();

	}

	private void writeDataElement(XMLStreamWriter writer, String value, String elementName) throws XMLStreamException {
		writer.writeStartElement(elementName);
		writer.writeCharacters(value);
		writer.writeEndElement();
	}

}
