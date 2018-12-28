package com.quicklearn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.domain.Course;
import com.quicklearn.persistence.CourseRepository;



@RestController
public class CourseController {

	@Autowired
	private  CourseRepository repository;

	public CourseController(CourseRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/courses")
	List<Course> all() {
		return repository.findAll();
	}

	@PostMapping("/courses")
	Course newCourse (@RequestBody Course newCourse) {
		return repository.save(newCourse);
	}

	@GetMapping("/courses/{courseId}")
	Course retrieveACourse(@PathVariable int courseId) {
		return repository.findById(courseId);
	}
	
}
