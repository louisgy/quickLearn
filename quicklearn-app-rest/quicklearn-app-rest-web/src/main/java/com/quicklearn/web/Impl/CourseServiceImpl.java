package com.quicklearn.web.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.quicklearn.domain.Course;
import com.quicklearn.persistence.CourseRepository;
import com.quicklearn.web.dto.CourseDTO;
import com.quicklearn.web.service.CourseService;

@Transactional
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;
	@Override
	public Course createCourse(CourseDTO courseDto) {
		Course course = new Course();
		course.setCategorie(courseDto.getCategorie());
		course.setCode(courseDto.getCode());
		course.setDescription(courseDto.getDescription());
		course.setDomain(courseDto.getDomain());
		course.setTitle(courseDto.getTitle());
		return courseRepository.save(course);
	}

	@Override
	public Course editCourse() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Course> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findByField(String field, String fieldName) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCodeExist(String code) {
		return (courseRepository.findByCode(code).isEmpty());
	}
	
	public boolean isTitleExist(String title) {
		return (courseRepository.findByTitle(title).isEmpty());
	}
	
	public boolean isExist(int id) {
		return (courseRepository.existsById(id));
	}
	
	

}
