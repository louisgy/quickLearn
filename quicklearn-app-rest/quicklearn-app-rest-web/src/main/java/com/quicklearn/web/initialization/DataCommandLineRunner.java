package com.quicklearn.web.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.Course;
import com.quicklearn.domain.User;
import com.quicklearn.persistence.CourseRepository;
import com.quicklearn.persistence.UserRepository;

@Component
public class DataCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CourseRepository  courseRepository;
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.save(new User("glouis@gmail.com",new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),"Georgy","Louis","admin"));
		userRepository.save(new User("Daniela@gmail.com",new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),"Daniela","Tingue","admin"));
		userRepository.save(new User("junior@gmail.com",new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),"junior","Tingue","admin"));
		userRepository.save(new User("Ghislaine@gmail.com",new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),"Ghislaine","Tingue","admin"));
		userRepository.save(new User("mariedaniella@gmail.com",new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),"Marie Daniela","Tingue","admin"));
		userRepository.save(new User("Judith@gmail.com",new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),"Georgy","Louis","admin"));
		userRepository.save(new User("Sylvie@gmail.com",new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),"Sylvie","Eliassaint","admin"));
		userRepository.save(new User("pognon@gmail.com",new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),"Bovoix","Pognon","admin"));
		
		courseRepository.save(new Course("Technologie","Science informatiques","Sciences Appliquees 234","Java certification basic","NT 456"));
		courseRepository.save(new Course("Technologie","Science informatiques","Computer fundamental","Java certification advance","JV789"));
		courseRepository.save(new Course("politic","Science informatiques","","Computer advanced","GWJ-890"));
		courseRepository.save(new Course("Histoire","Science informatiques","Geographie Appliquee","Java certification basic","GFD-890"));
		courseRepository.save(new Course("Technologie","Science informatiques","Histoire de Revolution","Java certification basic","NFH-890"));
		courseRepository.save(new Course("Technologie","Science informatiques","Baic information","Java certification basic","GHF-890"));
		courseRepository.save(new Course("Technologie","Science informatiques","Drame","Java certification basic","HGF-890"));
		
	}

}
