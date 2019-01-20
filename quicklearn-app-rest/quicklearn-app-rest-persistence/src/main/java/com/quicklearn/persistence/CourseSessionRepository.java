package com.quicklearn.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quicklearn.domain.CourseSession;



public interface CourseSessionRepository extends JpaRepository<CourseSession, Integer>{

}
