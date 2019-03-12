package com.quicklearn.web;



import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.web.Impl.EnrollmentServiceImpl;
import com.quicklearn.web.dto.EnrollmentDTO;
import com.quicklearn.web.error.FieldErrorDTO;
import com.quicklearn.web.error.ValidationResultDTO;


@RestController
public class EnrollmentController {
	
	@Autowired
	private EnrollmentServiceImpl enrollmentServiceImpl;
	

	

	@PostMapping("/enroll")
	public ResponseEntity<ValidationResultDTO> EnrollStudent(@Valid @RequestBody EnrollmentDTO enrollmentdto, BindingResult bindingResult) {
		ValidationResultDTO validationResultDTO = new ValidationResultDTO();
		
		if (bindingResult.hasErrors()) {

			if (bindingResult.hasGlobalErrors()) {

				ObjectError globalError = bindingResult.getGlobalError(); // Get the first Global Error, need to manage
																			// potential cases of
																			// more than one global error with using
																			// getGlobalErrors() instead
				validationResultDTO.addGlobalError(globalError.getDefaultMessage());
			}

			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			List<FieldErrorDTO> fieldErrorDTOs = fieldErrors.stream().map(FieldErrorDTO::new)
					.collect(Collectors.toList());

			validationResultDTO.setFieldErrors(fieldErrorDTOs);

			return new ResponseEntity<>(validationResultDTO, HttpStatus.BAD_REQUEST);

		} else if (enrollmentServiceImpl.createEnrollment(enrollmentdto.getUserId(), enrollmentdto.getCourseSessionId(), enrollmentdto.getEnrolledDate()) != null) {

			validationResultDTO.addGlobalError("Account successfully created");

			return new ResponseEntity<>(validationResultDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationResultDTO(), HttpStatus.BAD_REQUEST);
		
	}
	
//	@PostMapping("/enroll/{userid}/{coursesessionid}/enrollement")
//	public Enrollment EnrollStudent(@PathVariable (value = "userid" )int userId, @PathVariable (value = "coursesessionid") int courseSessionId,@RequestBody Enrollment newEnrollment)
//			{
//		//System.out.println("FFFFFFFFFFFFFFFFFFF :"+newEnrollment.toString());
//		System.out.println("FFFFFFFFFFFFFFFFFFF :");
//		newEnrollment.setId(new EnrollmentId(userId,courseSessionId)); // use optional for null EnrollementId 
//		return userRepository.findById(userId).map(user ->{
//			
//			newEnrollment.setUser(user);
//			
//			courseSessionRepository.findById(courseSessionId).map(courseSession ->{
//				newEnrollment.setCourseSession(courseSession);
//				
//				
//				return enrollmentRepository.save(newEnrollment);
//			}).orElseThrow(() -> new ResourceNotFoundException("Course Sesssion id: " + courseSessionId + " not found"));
//			
//			return newEnrollment;
//		}).orElseThrow(() -> new ResourceNotFoundException("Student id " + userId + " not found"));
//		
//	}
//	
	
	
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
