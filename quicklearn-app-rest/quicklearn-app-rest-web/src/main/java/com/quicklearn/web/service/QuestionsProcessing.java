package com.quicklearn.web.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.QuestionContent;

@Component
public class QuestionsProcessing {

	public List<QuestionContent> readAllQuestions(String filename, int questionsRequested[])
			throws FileNotFoundException, XMLStreamException {
		List<QuestionContent> data = new ArrayList<>();

		QuestionContent question = new QuestionContent();
		boolean flag = true;
		Reader reader = new FileReader(filename);
		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
		XMLStreamReader xmlInputReader = xmlInputFactory.createXMLStreamReader(reader);

		while (xmlInputReader.hasNext()) {
			int eventType = xmlInputReader.next();
			if (xmlInputReader.getEventType() == XMLEvent.START_ELEMENT) {
				String elementName = xmlInputReader.getName().toString();
				switch (elementName) {
				case "question":
					if (checkList(questionsRequested,
							Integer.parseInt(xmlInputReader.getAttributeValue("", QuestionContent.ID)))) {
						question = new QuestionContent();
						data.add(question);
						question.setId(Integer.parseInt(xmlInputReader.getAttributeValue("", QuestionContent.ID)));
						question.setCategory(xmlInputReader.getAttributeValue("", QuestionContent.CATEGORY));
						flag = true;
						break;
					} else {
						flag = false;
					}
					break;
				case QuestionContent.OPTION:
					if (!flag)
						break;
					String[] options = { xmlInputReader.getAttributeValue(0), xmlInputReader.getElementText() };
					question.addOptions(options);
					break;
				case QuestionContent.INSTRUCTIONS:
					if (!flag)
						break;
					question.setInstructions(xmlInputReader.getElementText());
					break;
				case QuestionContent.STATEMENT:
					if (!flag)
						break;
					question.setStatement(xmlInputReader.getElementText());
				default:
					break;
				}
			}

		}
		return data;
	}

	public boolean checkList(int questions[], int value) {
		for (int a : questions) {
			if (a == value)
				return true;
		}
		return false;
	}
	
	public void regQuestions(String fileName, List<QuestionContent> questions) throws IOException, XMLStreamException {
		boolean isEmpty = true;
		File f = new File(fileName);
		if (!f.exists()) f.createNewFile();
		
		if(!(f.length() == 0)) isEmpty=false;
		
		XMLInputFactory xmlif = XMLInputFactory.newFactory();
        FileReader fr = new FileReader(fileName);
        XMLEventReader xmler = xmlif.createXMLEventReader(fr);
        while (xmler.hasNext())
        {
           XMLEvent xmle = xmler.nextEvent();
           switch (xmle.getEventType())
           {
              case XMLEvent.START_ELEMENT:
            	  StartElement s = xmle.asStartElement();
            	  String tagName = s.getName().getLocalPart();
            	  System.out.println("\n\n"+"Start ELement : "+tagName+"\n\n");
//                 out.println("START_ELEMENT");
//                 out.printf("  Qname = %s%n",
//                            ((StartElement) xmle). getName());
                 break;
              case XMLEvent.END_ELEMENT:
//                 out.println("END_ELEMENT");
//                 out.printf("  Qname = %s%n",
//                            ((EndElement) xmle). getName());
            	  break;
            	default:
            		break;
           }
        }
		
		
		
		
		
		
		
		
	}

	public void registerQuestions(String fileName, List<QuestionContent> questions)
			throws XMLStreamException, IOException {
		
		boolean isEmpty = true;
		File f = new File(fileName);
		if (!f.exists()) f.createNewFile();
		
		if(!(f.length() == 0)) isEmpty=false;
	
		// writer
		
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		StringWriter sw = new StringWriter();
		XMLStreamWriter writer = factory.createXMLStreamWriter(sw);
		
		// Reader 
		
		Reader reader = new FileReader(fileName);
		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
		XMLStreamReader xmlInputReader = xmlInputFactory.createXMLStreamReader(reader);

		
		if(isEmpty) {
		writer.writeStartDocument();
		writer.writeStartElement("customers");
		}
		
	
		
		for (QuestionContent question : questions) {
			if(isEmpty)
			addAQuestion(writer, question);
			else {
				int eventType = xmlInputReader.next();
				eventType = xmlInputReader.next();
				addAQuestion(writer, question);
			}
		}	
		
		if(isEmpty) {
		writer.writeEndElement();
		writer.writeEndDocument();
		}

		writer.flush();
		writer.close();

		FileWriter fr = new FileWriter(f, true);
		fr.write(sw.toString());
		fr.close();

	}
	

	public void addAQuestion(XMLStreamWriter writer, QuestionContent question) throws XMLStreamException {
		writer.writeStartElement("question");
		writer.writeAttribute(QuestionContent.ID, Integer.toString(question.getId()));
		writeDataElement(writer, question.getInstructions(), QuestionContent.INSTRUCTIONS);
		writeDataElement(writer, question.getStatement(), QuestionContent.STATEMENT);

		writer.writeEndElement();
	}

	private void writeDataElement(XMLStreamWriter writer, String value, String elementName) throws XMLStreamException {
		writer.writeStartElement(elementName);
		writer.writeCharacters(value);
		writer.writeEndElement();
	}

	public List<QuestionContent> ReadSomeQuestions() {
		return null;
	}

//	public void registerQuestion(List<QuestionContent> data, String filename) throws XMLStreamException {
//
//		XMLOutputFactory factory = XMLOutputFactory.newInstance();
//
//		StringWriter sw = new StringWriter();
//		XMLStreamWriter writer = factory.createXMLStreamWriter(sw);
//
////		IndentingXMLStreamWriter writer = new IndentingXMLStreamWriter(w);
//
//		writer.writeStartDocument();
//		writer.writeStartElement("questions");
//
//		for (QuestionContent questionContent : data) {
//			createQuestionElement(writer, questionContent);
//			System.out.println("\n\n" + "IT REALLY HAPPEN *********************");
//			System.out.println("Instructions :" + questionContent.getInstructions());
//			System.out.println("Statement :" + questionContent.getStatement());
//		}
//
//		writer.writeEndElement();
//		writer.writeEndDocument();
//
//		writer.flush();
//		writer.close();
//	}

	private void updateQuestion(int questionId) {

	}

	private void removeQuestion(int questionId) {

	}

	private QuestionContent findQuestions(List<Integer> id) {

		return null;
	}

//	private void createQuestionElement(XMLStreamWriter writer, QuestionContent questionContent)
//			throws XMLStreamException {
//		writer.writeStartElement("question");
//		writer.writeAttribute(QuestionContent.ID, Integer.toString(questionContent.getId()));
//		writeDataElement(writer, questionContent.getInstructions(), QuestionContent.INSTRUCTIONS);
//		writer.writeEndElement();
//
//	}

}
