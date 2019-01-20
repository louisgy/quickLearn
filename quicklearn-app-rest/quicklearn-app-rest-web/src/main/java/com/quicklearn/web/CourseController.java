package com.quicklearn.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.domain.Course;
import com.quicklearn.persistence.CourseRepository;
import com.quicklearn.web.Impl.CourseServiceImpl;
import com.quicklearn.web.dto.CourseDTO;
import com.quicklearn.web.error.FieldErrorDTO;
import com.quicklearn.web.error.ValidationResultDTO;
import com.quicklearn.web.validator.CourseValidator;



@RestController
public class CourseController {
	@Autowired
	private CourseValidator courseValidator;
	
	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@Autowired
	private  CourseRepository repository;

	public CourseController(CourseRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/courses")
	List<Course> all() {
		return repository.findAll();
	}

	@PostMapping("/newCourse")
	public  ResponseEntity<ValidationResultDTO>  newCourse (@RequestBody CourseDTO newCourseDTO,BindingResult bindingResult) {
		courseValidator.validate(newCourseDTO, bindingResult);
		ValidationResultDTO validationResultDto = new ValidationResultDTO();

		if(bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			List<FieldErrorDTO> fieldErrorDTOs = fieldErrors.stream().map(FieldErrorDTO::new)
					.collect(Collectors.toList());

			validationResultDto.setFieldErrors(fieldErrorDTOs);

			return new ResponseEntity<>(validationResultDto, HttpStatus.BAD_REQUEST);

		} else if (courseServiceImpl.createCourse(newCourseDTO) != null) {

			validationResultDto.addGlobalError("Account successfully created");

			return new ResponseEntity<>(validationResultDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationResultDTO(), HttpStatus.BAD_REQUEST);

	}
	

	
	@GetMapping("/courses/{courseId}")
	Course retrieveACourse(@PathVariable int courseId) {
		return repository.findById(courseId);
	}
	
}
