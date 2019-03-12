package com.quicklearn.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quicklearn.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByIdAndRole(int id, String role);
	User findById(int id);
	 User findByEmail(String email);
	 Optional<User> findByEmailAndRoleAllIgnoreCase(String email, String
			 role);
}
