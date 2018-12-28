package com.quicklearn.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quicklearn.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	Teacher findById(int i);
}
