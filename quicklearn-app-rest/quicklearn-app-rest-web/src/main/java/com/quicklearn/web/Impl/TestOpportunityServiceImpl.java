package com.quicklearn.web.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quicklearn.domain.TestOpportunity;
import com.quicklearn.persistence.CourseSessionRepository;
import com.quicklearn.persistence.TestOpportunityRepository;
import com.quicklearn.persistence.TestRepository;
import com.quicklearn.web.dto.TestOpportunityDTO;
import com.quicklearn.web.service.TestOpportunityService;

@Service
public class TestOpportunityServiceImpl implements TestOpportunityService{
	
	@Autowired
	TestRepository testRepository;
	@Autowired
	CourseSessionRepository courseSessionRepository;
	@Autowired
	TestOpportunityRepository  testOpportunityRepository;

	@Transactional
	@Override
	public TestOpportunity saveTestOpportunity(TestOpportunityDTO t) {
		TestOpportunity testOpptortunity = new TestOpportunity();
		testOpptortunity.setActive(t.isActive());
		testOpptortunity.setAverageGrade(t.getAverageGrade());
		testOpptortunity.setCourseSession(courseSessionRepository.findById(t.getCourseSessionId()));
		testOpptortunity.setTest(testRepository.findById(t.getTestId()));
		testOpptortunity.setDateEndAllowed(t.getDateEndAllowed());
		testOpptortunity.setDateStartAllowed(t.getDateStartAllowed());
		testOpptortunity.setMaxStudents(t.getMaxStudents());
		testOpptortunity.setMaxAttemptAllowed(t.getMaxAttemptAllowed());
		
		return testOpportunityRepository.save(testOpptortunity);
	}
	
}
