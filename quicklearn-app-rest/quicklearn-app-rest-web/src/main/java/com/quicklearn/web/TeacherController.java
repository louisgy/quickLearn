package com.quicklearn.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.domain.Teacher;
import com.quicklearn.persistence.TeacherRepository;


@RestController
public class TeacherController {
	private final TeacherRepository repository;

	public TeacherController(TeacherRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/teacher")
	List<Teacher> all() {
		return repository.findAll();
	}

	@PostMapping("/teacher")
	Teacher newTeacher (@RequestBody Teacher newTeacher) {
		return repository.save(newTeacher);
	}

}
