package com.quicklearn.web.initialization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.quicklearn.domain.User;
import com.quicklearn.persistence.UserRepository;

@Component
public class UserData {
//	
	@Autowired
	private UserRepository userRepository;
	
	List <User> userList;
	
	public UserData() {

	}
	

	public List <User> newUser() {
		
		userList = new ArrayList <User>();
		
		User user1 = new User("glouis@gmail.com", new BCryptPasswordEncoder().encode("P4aRs#s2rtw"), "Georgy", "Louis",
				"s");
		User user2 = new User("Daniela@gmail.com", new BCryptPasswordEncoder().encode("P4aRs#s2rtw"), "Daniela",
				"Tingue", "s");
		User user3 = new User("junior@gmail.com", new BCryptPasswordEncoder().encode("P4aRs#s2rtw"), "junior", "Tingue",
				"s");
		User user4 = new User("Ghislaine@gmail.com", new BCryptPasswordEncoder().encode("P4aRs#s2rtw"), "Ghislaine",
				"Tingue", "t");
		User user5 = new User("mariedaniella@gmail.com", new BCryptPasswordEncoder().encode("P4aRs#s2rtw"),
				"Marie Daniela", "Tingue", "t");
		User user6 = new User("Judith@gmail.com", new BCryptPasswordEncoder().encode("P4aRs#s2rtw"), "Georgy", "Louis",
				"t");
		User user7 = new User("Sylvie@gmail.com", new BCryptPasswordEncoder().encode("P4aRs#s2rtw"), "Sylvie",
				"Eliassaint", "t");
		User user8 = new User("pognon@gmail.com", new BCryptPasswordEncoder().encode("P4aRs#s2rtw"), "Bovoix", "Pognon",
				"t");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		userRepository.save(user6);
		userRepository.save(user7);
		userRepository.save(user8);
		
		return userList;
		
	}

}
