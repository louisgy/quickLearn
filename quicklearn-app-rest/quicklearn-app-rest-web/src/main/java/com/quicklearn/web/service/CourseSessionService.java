package com.quicklearn.web.service;

import java.util.Date;

import com.quicklearn.domain.CourseSession;

public interface CourseSessionService {
	public boolean isSessionExist(int i);
	public CourseSession createCourseSession(int userId,int courseId, Date startDate, Date endDate,long averageGrade);
}
