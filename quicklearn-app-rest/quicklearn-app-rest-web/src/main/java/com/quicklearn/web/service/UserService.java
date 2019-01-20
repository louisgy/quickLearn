package com.quicklearn.web.service;

import java.util.List;
import java.util.Optional;

import com.quicklearn.domain.User;
import com.quicklearn.web.dto.UserDTO;
import com.quicklearn.web.dto.UserLoginDTO;

public interface UserService {
	public User createUser(UserDTO userDto);
	public User editUser(User user);
	public User findUser();
	public List<User>findAllUsers();
	public boolean authenticate(UserLoginDTO userLoginDto);
	public User findUserByEmail(final String email);

}
