package com.quicklearn.web.initialization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.Course;
import com.quicklearn.persistence.CourseRepository;
import com.quicklearn.persistence.UserRepository;

@Component
public class CourseData {
	
	@Autowired
	private CourseRepository courseRepository;
	
	private  List<Course> listCourse ;
	
	public CourseData() {
		super();
	}

	public List<Course> newCourse () {
		listCourse = new ArrayList<Course>();
		Course course1 = new Course("Technologie", "Science informatiques", "Sciences Appliquees 234",
				"Java certification basic", "NT 456");

		Course course2 = new Course("Technologie", "Medical Sciences", "Computer fundamental",
				"Java certification advance", "JV789");
		Course course3 = new Course("politic", "Economics", "", "Computer advanced", "GWJ-890");
		Course course4 = new Course("Histoire", "Cybersecurity Technology", "Geographie Appliquee",
				"Java certification basic", "GFD-890");
		Course course5 = new Course("Technologie", "Business and Management", "Histoire de Revolution",
				"Java certification basic", "NFH-890");
		Course course6 = new Course("Technologie", "Social Science", "Baic information", "Java certification basic",
				"GHF-890");
		Course course7 = new Course("Technologie", "Marketing", "Drame", "Java certification basic", "HGF-890");
		Course course8 = new Course("Technologie", " Political Sciences", "Drame", "Java certification basic",
				"HGF-890");
//		
//		listCourse.add(course1);
//		listCourse.add(course2);
//		listCourse.add(course3);
//		listCourse.add(course4);
//		listCourse.add(course5);
//		listCourse.add(course6);
//		listCourse.add(course7);
//		listCourse.add(course8);
//
//		courseRepository.save(course1);
//		courseRepository.save(course2);
//		courseRepository.save(course3);
//		courseRepository.save(course4);
//		courseRepository.save(course5);
//		courseRepository.save(course6);
//		courseRepository.save(course7);
//		courseRepository.save(course7);
		
		
		listCourse.add(courseRepository.save(course1));
		listCourse.add(courseRepository.save(course2));
		listCourse.add(courseRepository.save(course3));
		listCourse.add(courseRepository.save(course4));
		listCourse.add(courseRepository.save(course5));
		listCourse.add(courseRepository.save(course6));
		listCourse.add(courseRepository.save(course7));
		listCourse.add(courseRepository.save(course8));

//		courseRepository.save(course1);
//		courseRepository.save(course2);
//		courseRepository.save(course3);
//		courseRepository.save(course4);
//		courseRepository.save(course5);
//		courseRepository.save(course6);
//		courseRepository.save(course7);
//		courseRepository.save(course7);
		
		return listCourse;
}

}
