package com.quicklearn.web;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.domain.Enrollment;
import com.quicklearn.domain.EnrollmentId;
import com.quicklearn.persistence.CourseSessionRepository;
import com.quicklearn.persistence.EnrollmentRepository;
import com.quicklearn.persistence.UserRepository;
import com.quicklearn.web.exception.ResourceNotFoundException;


@RestController
public class EnrollmentController {

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CourseSessionRepository courseSessionRepository;

	@PostMapping("/enrolle/{studentId}/{courseSessionId}/enrollement")
	public Enrollment EnrollStudent(@PathVariable int userId, @PathVariable int courseSessionId,@RequestBody Enrollment newEnrollment)
			throws ParseException {
		
		newEnrollment.setId(new EnrollmentId(userId,courseSessionId)); // use optional for null EnrollementId 
		return userRepository.findById(userId).map(user ->{
			
			newEnrollment.setUser(user);


			courseSessionRepository.findById(courseSessionId).map(courseSession ->{
				newEnrollment.setCourseSession(courseSession);
				
				
				return enrollmentRepository.save(newEnrollment);
			}).orElseThrow(() -> new ResourceNotFoundException("Course Sesssion id: " + courseSessionId + " not found"));
			
			return newEnrollment;
		}).orElseThrow(() -> new ResourceNotFoundException("Student id " + userId + " not found"));
		


	}
	
	
// This code below works fine
	
/////////////////////////////////////// BEGIN ////////////////////////////////////

//	@PostMapping("/enrolle/{studentId}/{courseSessionId}/enrollement")
//	public Enrollement EnrollStudent(@PathVariable int studentId, @PathVariable int courseSessionId,@RequestBody Enrollement newEnrollement)
//			throws ParseException {
//		
//		newEnrollement.setId(new EnrollementId(studentId,courseSessionId)); // use optional for null EnrollementId 
//		return studentRepository.findById(studentId).map(student ->{
//			
//			newEnrollement.setStudent(student);
//			
//			courseSessionRepository.findById(courseSessionId).map(courseSession ->{
//				newEnrollement.setCourseSession(courseSession);
//				
//				
//				return enrollementRepository.save(newEnrollement);
//			}).orElseThrow(() -> new ResourceNotFoundException("Course Sesssion id: " + courseSessionId + " not found"));
//			
//			return newEnrollement;
//		}).orElseThrow(() -> new ResourceNotFoundException("Student id " + studentId + " not found"));
//		
//
//
//	} 
	//////////////////////////END ////////////////////////////////////////////////////
}
