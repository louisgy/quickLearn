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

import com.quicklearn.web.Impl.CourseSessionImpl;
import com.quicklearn.web.dto.CourseSessionDTO;
import com.quicklearn.web.error.FieldErrorDTO;
import com.quicklearn.web.error.ValidationResultDTO;

@RestController
public class CourseSessionController {

	@Autowired
	private CourseSessionImpl courseSessionImpl;

	@PostMapping("/newCourseSession")
	public ResponseEntity<ValidationResultDTO> newCourseSession(@Valid @RequestBody CourseSessionDTO sessiondto,
			BindingResult bindingResult) {
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

		} else if (courseSessionImpl.createCourseSession(sessiondto.getUserId(), sessiondto.getCourseId(),
				sessiondto.getDateStart(), sessiondto.getDateEnd(), sessiondto.getAverageGrade()) != null) {

			validationResultDTO.addGlobalError("Account successfully created");
			
			return new ResponseEntity<>(validationResultDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationResultDTO(), HttpStatus.BAD_REQUEST);
	}
}

//@PostMapping("/coursession/{courseid}/{teacherid}/coursesessions")
//CourseSession newCourseSession (@PathVariable (value = "teacherid") Integer teacherId, @PathVariable (value = "courseid") Integer courseId,@RequestBody CourseSession newCourseSession) {
//	System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTT : "+newCourseSession.toString());
//
//	return courseRepository.findById(courseId).map(course -> {
//		newCourseSession.setCourse(course);
//		
//		userRepository.findById(teacherId).map(user ->{
//			 newCourseSession.setUser(user);
//			 return courseSessionRepository.save(newCourseSession);
//		}).orElseThrow(() -> new ResourceNotFoundException("teacherId " + teacherId + " not found"));
//		
//		//this return is not necessary, I believe
//        return courseSessionRepository.save(newCourseSession);
//    }).orElseThrow(() -> new ResourceNotFoundException("PostId " + courseId + " not found"));
//	
//	
//
//} // End newCourseSession
//
//} // End CourseSessionController
//

//CourseSession newCourseSession (@PathVariable (value = "email") String eMail, @PathVariable (value = "role") String rOle,@PathVariable (value = "courseid") Integer courseId,@RequestBody CourseSession newCourseSession) {
//	
//	return courseRepository.findById(courseId).map(course ->{
//		newCourseSession.setCourse(course);
//		userRepository.findByEmailAndRoleAllIgnoreCase(eMail,rOle).map(user->{
//			newCourseSession.setUser(user);})
//		userRepository.findByEmailAndRoleAllIgnoreCase(eMail,rOle).map( user->{
//			newCourseSession.setUser
//		})
//	});
//	return newCourseSession;
//
//
//	return courseRepository.findById(courseId).map(course -> {
//		newCourseSession.setCourse(course);
//		
//		userRepository.findById(teacherId).map(user ->{
//			 newCourseSession.setTeacher(teacher); 
//			 return courseSessionrepository.save(newCourseSession);
//		}).orElseThrow(() -> new ResourceNotFoundException("teacherId " + teacherId + " not found"));
//		
//		//this return is not necessary, I believe
//        return courseSessionrepository.save(newCourseSession);
//    }).orElseThrow(() -> new ResourceNotFoundException("PostId " + courseId + " not found"));
//	
//	
//
//} //		System.out.println("GGGGGGGGGGGGGGGGGG "+courseRepository.findById(courseId).getClass().getTypeName());

//}
