package com.quicklearn.web.initialization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.Course;
import com.quicklearn.domain.CourseSession;
import com.quicklearn.domain.User;
import com.quicklearn.persistence.CourseSessionRepository;
import com.quicklearn.web.util.Utility;

@Component
public class CourseSessionData {
	
	@Autowired
	private CourseSessionRepository courseSessionRepository;
	
	@Autowired
	private Utility utility;
	
	List<CourseSession> courseSessionList;
	
	public CourseSessionData() {
		super();
	}

	public List<CourseSession> newCourseSession(List<Course> courseList, List<User> userList) throws ParseException {
		courseSessionList = new ArrayList <CourseSession>();
		CourseSession courseSession1 = new CourseSession(utility.formatDate("12/12/1998"), utility.formatDate("31/12/1998"), 10.00, courseList.get(1), userList.get(1));
		CourseSession courseSession2 = new CourseSession(utility.formatDate("12/12/1998"), utility.formatDate("31/12/1998"), 7.00, courseList.get(2), userList.get(2));
		CourseSession courseSession3 = new CourseSession(utility.formatDate("12/12/1998"), utility.formatDate("31/12/1998"), 9.00, courseList.get(3), userList.get(3));
		CourseSession courseSession4 = new CourseSession(utility.formatDate("12/12/1998"), utility.formatDate("31/12/1998"), 67.00, courseList.get(4), userList.get(4));
		CourseSession courseSession5 = new CourseSession(utility.formatDate("12/12/1998"), utility.formatDate("31/12/1998"), 32.00, courseList.get(5), userList.get(5));
		
		
//		courseSessionRepository.save(courseSession1);	
//		courseSessionRepository.save(courseSession2);
//		courseSessionRepository.save(courseSession3);
//		courseSessionRepository.save(courseSession4);
//		courseSessionRepository.save(courseSession5);
		
		courseSessionList.add(courseSessionRepository.save(courseSession1));
		courseSessionList.add(courseSessionRepository.save(courseSession2));
		courseSessionList.add(courseSessionRepository.save(courseSession3));
		courseSessionList.add(courseSessionRepository.save(courseSession4));
		courseSessionList.add(courseSessionRepository.save(courseSession5));
		
		return courseSessionList;
		
	}
	
	
}
