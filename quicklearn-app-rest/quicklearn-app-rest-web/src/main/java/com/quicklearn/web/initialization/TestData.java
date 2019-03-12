package com.quicklearn.web.initialization;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.Course;
import com.quicklearn.domain.Test;
import com.quicklearn.persistence.TestRepository;
import com.quicklearn.web.util.Utility;

@Component
public class TestData {
	@Autowired
	private TestRepository testRepository;
	
	
	@Autowired
	private Utility utility;
	Date dateP1;
	Date dateP2;
	Date dateP3 ;
	Date dateP4 ;
	
	Date dateS1 ;
	Date dateS2 ;
	Date dateS3 ;
	Date dateS4;
	

	Date dateE1 ;
	Date dateE2;
	Date dateE3 ;
	Date dateE4;
	private  List<Test> testList ;

	public TestData() {
	}
	
	public List<Test> AddNewTestData(List <Course> courseList) {
		testList = new ArrayList<Test>();
		
		try {
			dateP1 = utility.formatDate("28/7/2019");
			dateP2 = utility.formatDate("10/10/2020");
			dateP3 = utility.formatDate("27/8/2021");
			dateP4 = utility.formatDate("9/6/2022");
			
			dateS1 = utility.formatDate("28/7/2019");
			dateS2 = utility.formatDate("10/10/2020");
			dateS3 = utility.formatDate("27/8/2021");
			dateS4 = utility.formatDate("9/6/2022");
			

			dateE1 = utility.formatDate("28/7/2019");
			dateE2 = utility.formatDate("10/10/2020");
			dateE3 = utility.formatDate("27/8/2021");
			dateE4 = utility.formatDate("9/6/2022");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Test test1 = new Test(dateP1, dateS1, dateE1,true,"ADV",3200,courseList.get(1));
		Test test2 = new Test(dateP1, dateS1, dateE1,true,"ADV",3200,courseList.get(2));
		Test test3 = new Test(dateP1, dateS1, dateE1,true,"ADV",3200,courseList.get(3));
		Test test4 = new Test(dateP1, dateS1, dateE1,true,"MED",3200,courseList.get(4));
		
//		testRepository.save(test1);
//		testRepository.save(test2);
//		testRepository.save(test3);
//		testRepository.save(test4);
		
		testList.add(testRepository.save(test1));
		testList.add(testRepository.save(test2));
		testList.add(testRepository.save(test3));
		testList.add(testRepository.save(test4));
		
		return testList;
		
	}
	
	

}
