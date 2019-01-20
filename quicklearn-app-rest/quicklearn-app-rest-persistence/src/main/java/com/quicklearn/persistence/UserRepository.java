package com.quicklearn.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.quicklearn.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	 User findByEmail(String email);
	 Optional<User> findByEmailAndRoleAllIgnoreCase(String email, String
			 role);
}
