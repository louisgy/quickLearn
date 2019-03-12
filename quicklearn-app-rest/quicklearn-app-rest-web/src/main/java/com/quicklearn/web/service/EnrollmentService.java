package com.quicklearn.web.service;

import java.util.Date;

import com.quicklearn.domain.Enrollment;

public interface EnrollmentService {
	public Enrollment createEnrollment(int userId, int courseSessionId,Date enrolledDate);
}
