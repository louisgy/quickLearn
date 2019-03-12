package com.quicklearn.web.Impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quicklearn.domain.Enrollment;
import com.quicklearn.domain.EnrollmentId;
import com.quicklearn.persistence.CourseSessionRepository;
import com.quicklearn.persistence.EnrollmentRepository;
import com.quicklearn.persistence.UserRepository;
import com.quicklearn.web.service.EnrollmentService;


@Transactional
@Service
public class EnrollmentServiceImpl  implements EnrollmentService{
	@Autowired
	CourseSessionRepository courseSessionRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Autowired
	Enrollment enrollment;
	
	@Override
	public Enrollment createEnrollment(int userId, int sessionId, Date enrolledDate ) {
		
		enrollment.setId(new EnrollmentId(userId,sessionId));
		enrollment.setUser(userRepository.findById(userId));
		enrollment.setCourseSession(courseSessionRepository.findById(sessionId));
		enrollment.setGrade((0L));
		enrollment.setEnrolledDate(enrolledDate);
		enrollment.setComplete(false);
		return enrollmentRepository.save(enrollment);
		

	}

}
