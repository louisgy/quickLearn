package com.quicklearn.web.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quicklearn.domain.CourseSession;
import com.quicklearn.persistence.CourseRepository;
import com.quicklearn.persistence.CourseSessionRepository;
import com.quicklearn.persistence.UserRepository;
import com.quicklearn.web.service.CourseSessionService;

@Service
public class CourseSessionImpl implements CourseSessionService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	CourseSessionRepository courseSessionRepository;
	
	@Override
	public boolean isSessionExist(int id) {
		return courseSessionRepository.existsById(new Integer(id));
	}

	@Override
	public CourseSession createCourseSession(int userId,int courseId, Date startDate, Date endDate,long averageGrade) {
		CourseSession courseSession = new CourseSession();
		courseSession.setCourse(courseRepository.findById(courseId));
		courseSession.setUser(userRepository.findById(userId));
		courseSession.setDateStart(startDate);
		courseSession.setDateEnd(endDate);
		courseSession.setAverageGrade(averageGrade);
		return courseSessionRepository.save(courseSession);
	}
}
