package com.quicklearn.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.quicklearn.domain.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	Course findById(int i);
}
	