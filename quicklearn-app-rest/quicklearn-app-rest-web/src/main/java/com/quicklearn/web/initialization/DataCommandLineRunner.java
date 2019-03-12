package com.quicklearn.web.initialization;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.Course;
import com.quicklearn.domain.CourseSession;
import com.quicklearn.domain.Test;
import com.quicklearn.domain.TestOpportunity;
import com.quicklearn.domain.User;
import com.quicklearn.web.util.Utility;;

@Component
public class DataCommandLineRunner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataCommandLineRunner.class);

	Utility utility;
	@Autowired
	private UserData userData;
			
	@Autowired
	private CourseData courseData;

	@Autowired
	private CourseSessionData courseSessionData;
	
	@Autowired
	private TestData testData;
	
	@Autowired
	TestOpportunityData testOpportunityData;

	@Override
	public void run(String... args) throws Exception {
		logger.info("Loading data from DataLoader...");
		
//		utility.createDataFile();

		List <User> userList =  new ArrayList <User>();
		List <Course> courseList =  new ArrayList <Course>();
		List <Test> testList =  new ArrayList <Test>();
		List <CourseSession> courseSessionList =  new ArrayList <CourseSession>();

		userList=userData.newUser();
		courseList=courseData.newCourse();
		courseSessionList=courseSessionData.newCourseSession(courseList, userList);
		testList=testData.AddNewTestData(courseList);
		testOpportunityData.addNewTestOpportunity(courseSessionList, testList);
	}

}
