package com.quicklearn.web.service;

import com.quicklearn.domain.Course;
import com.quicklearn.web.dto.CourseDTO;

import java.util.List;


public interface CourseService {
	
	public Course createCourse(CourseDTO courseDto);
	
	public Course editCourse();
	
	public List<Course> findByField(String field,String fieldName);
	public List<Course> findAllUsers();
	public List<Course> findUsers();
	


}
