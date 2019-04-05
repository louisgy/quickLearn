package com.quicklearn.web.Impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import com.quicklearn.domain.QuestionContent;
import com.quicklearn.web.service.QuestionsProcessing;

@Component
public class QuestionsProcessingImpl implements QuestionsProcessing {
	
//	@Value("${fileName}")
//	private String fileName;
	private String fileName = "qx.xml";
	
	File file = new File(fileName);



	@Override
	public List<QuestionContent> getQuestions(int[] questionsRequested) throws JDOMException, IOException {
		List<QuestionContent> questionList = new ArrayList<QuestionContent>();

		QuestionContent q = new QuestionContent();
		SAXBuilder builder = new SAXBuilder(); 
		Document document  = (Document) builder.build(file);
		Element rootNode = document.getRootElement(); 
		System.out.println("Root node :"+rootNode.getName());
		List<Element> listElement = rootNode.getChildren("question"); 
		
//		System.out.println("list options size :"+listElement.size()+"-----------");
//		Object [] elements = listElement.toArray();
//		for(Object el : elements) {
//			System.out.println(el.toString());
//		}
//		for(Element ele : listElement ) {
//			System.out.println(ele.getAttributeValue("Element:"+ele.getName()+"attribute :"+"ans"));
//		}
	
	    for(Element e : listElement) {
	    	List<Element> children = e.getChildren();
	    	q.setCategory( e.getAttributeValue("category"));
	    	q.setId(Integer.parseInt(e.getAttributeValue("id")));
	    	System.out.println(e.getAttributeValue("category"));
	    	for (Element child : children) {
	    		System.out.println("Child name "+child.getName());
	    		if(child.getName().equals("instructions")) {
	    				}
	    	}
	    	questionList.add(q);
//	    	
//	    	q.setCategory( e.getAttributeValue("category"));
//	    	q.setId(Integer.parseInt(e.getAttributeValue("id")));
//	    	q.setStatement(e.getChildText("statement"));   	
//	    	List<Element> listOptions = e.getChildren("options");
//	    	System.out.println("list options size :"+listOptions.size()+"-----------");
//    		
//	    	List<String> option = new ArrayList<String>();
//	    	String [][] optArray = new String[listOptions.size()][listOptions.size()];
//	    	for(Element opt : listOptions) {
//	    		optArray [0][listOptions.indexOf(opt)] = opt.getAttributeValue("option");
//	    		optArray [1][listOptions.indexOf(opt)] = opt.getText();
//	    		option.add(opt.getAttributeValue("option"));
//	    	}

	    	
	    
	    }
		
		return questionList;
	}

}
