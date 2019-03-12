package com.quicklearn.web.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quicklearn.domain.User;
import com.quicklearn.persistence.UserRepository;
import com.quicklearn.web.dto.UserDTO;
import com.quicklearn.web.dto.UserLoginDTO;
import com.quicklearn.web.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
 
	@Override
	public User createUser(UserDTO userdto) {
		User user = new User();
		user.setEmail(userdto.getEmail());
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
		user.setRole(userdto.getRole());
		return userRepository.save(user);
	}

	@Override
	public User editUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authenticate(UserLoginDTO userLoginDto) {
		
		User userEntity = userRepository.findByEmail(userLoginDto.getEmail());

		if (userEntity != null) {
		//	if (userEntity.getPassword().equals(userLoginDto.getPassword()))
			if (new BCryptPasswordEncoder().matches(userLoginDto.getPassword(), userEntity.getPassword()))
				return true;
			else
				return false;
		}

		else

			return false;
	}
	 
	public boolean  authenticate (String email,String password) {
		User userEntity = userRepository.findByEmail(email);

		if (userEntity != null) {
		//	if (userEntity.getPassword().equals(password))
			if (new BCryptPasswordEncoder().matches(password, userEntity.getPassword()))
				return true;
			else
				return false;
		}

		else

			return false;
	}
	
	public boolean resetPassword(String email, String password) {
		User userEntity = userRepository.findByEmail(email);
		//userEntity.setPassword(password);
		userEntity.setPassword(new BCryptPasswordEncoder().encode(password));
		if(userRepository.save(userEntity) != null)
			return true;
			else
		return false;
	}
	
	public boolean studentExist(int id ) {
		return userRepository.existsById(id);
	}

	@Override
	public User findUserByEmail(String email) {
		 return userRepository.findByEmail(email);
	}
	
	public boolean isTeacherExist(int id, String role) {
		if(userRepository.findByIdAndRole(id, role) != null)
			return  true ;
		else			
		return false;
	}
	
}