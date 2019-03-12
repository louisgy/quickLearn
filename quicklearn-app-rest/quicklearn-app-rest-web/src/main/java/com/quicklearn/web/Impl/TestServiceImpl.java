package com.quicklearn.web.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quicklearn.domain.Test;
import com.quicklearn.persistence.CourseRepository;
import com.quicklearn.persistence.TestRepository;
import com.quicklearn.web.dto.TestDTO;
import com.quicklearn.web.service.TestService;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Test saveTest(TestDTO testdto) {
		Test test = new Test();
		test.setAvailabilityStatus(testdto.isAvailabilityStatus());
		test.setDateAvailabilityStart(testdto.getDateAvailabilityStart());
		test.setDateAvailabilityEnd(testdto.getDateAvailabilityEnd());
		test.setDatePublished(testdto.getDatePublished());
		test.setWeight(testdto.getWeight());
		test.setDuration(testdto.getDuration());
		test.setCourse(courseRepository.findById(testdto.getCourseId()));
		return testRepository.save(test);
	}

}
