package com.quicklearn.web.initialization;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.CourseSession;
import com.quicklearn.domain.Test;
import com.quicklearn.domain.TestOpportunity;
import com.quicklearn.persistence.TestOpportunityRepository;
import com.quicklearn.web.util.Utility;

@Component
public class TestOpportunityData {
	
	@Autowired
	private TestOpportunityRepository testOpportunityRepository;
	
	@Autowired
	private Utility utility;

	
	Date dateS1 ;
	Date dateS2 ;
	Date dateS3 ;
	Date dateS4;
	

	Date dateE1 ;
	Date dateE2;
	Date dateE3 ;
	Date dateE4;
	
	public TestOpportunityData() {
	}
	
	public void addNewTestOpportunity(List<CourseSession> courseSessionList, List<Test> testList) {
		
		try {
			dateS1 = utility.formatDate("28/7/2019");
			dateS2 = utility.formatDate("10/10/2020");
			dateS3 = utility.formatDate("27/8/2021");
			dateS4 = utility.formatDate("9/6/2022");
			

			dateE1 = utility.formatDate("28/9/2019");
			dateE2 = utility.formatDate("10/20/2020");
			dateE3 = utility.formatDate("27/9/2021");
			dateE4 = utility.formatDate("9/7/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TestOpportunity TestOpportunity1 = new TestOpportunity(12,20L,dateS1,dateE1,true,23,courseSessionList.get(1),testList.get(1));
		TestOpportunity TestOpportunity2 = new TestOpportunity(30,20L,dateS1,dateE1,false,20,courseSessionList.get(1),testList.get(1));
		TestOpportunity TestOpportunity3 = new TestOpportunity(34,20L,dateS1,dateE1,false,24,courseSessionList.get(1),testList.get(1));
		TestOpportunity TestOpportunity4 = new TestOpportunity(20,20L,dateS1,dateE1,true,25,courseSessionList.get(1),testList.get(1));
		
		testOpportunityRepository.save(TestOpportunity1);
		testOpportunityRepository.save(TestOpportunity2);
		testOpportunityRepository.save(TestOpportunity3);
		testOpportunityRepository.save(TestOpportunity4);
		
	
	}

}
