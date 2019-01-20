package com.quicklearn.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.web.exception.ResourceNotFoundException;
import com.quicklearn.domain.CourseSession;
import com.quicklearn.persistence.CourseRepository;
import com.quicklearn.persistence.CourseSessionRepository;
import com.quicklearn.persistence.UserRepository;


@RestController
public class CourseSessionController {

	@Autowired
	private CourseSessionRepository courseSessionRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/coursession/{courseid}/{teacherid}/coursesessions")
	CourseSession newCourseSession (@PathVariable (value = "teacherid") Integer teacherId, @PathVariable (value = "courseid") Integer courseId,@RequestBody CourseSession newCourseSession) {


		return courseRepository.findById(courseId).map(course -> {
			newCourseSession.setCourse(course);
			
			userRepository.findById(teacherId).map(user ->{
				 newCourseSession.setUser(user);
				 return courseSessionRepository.save(newCourseSession);
			}).orElseThrow(() -> new ResourceNotFoundException("teacherId " + teacherId + " not found"));
			
			//this return is not necessary, I believe
	        return courseSessionRepository.save(newCourseSession);
	    }).orElseThrow(() -> new ResourceNotFoundException("PostId " + courseId + " not found"));
		
		
	
	} // End newCourseSession
	
} // End CourseSessionController


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
