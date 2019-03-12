package com.quicklearn.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quicklearn.domain.CourseSession;


@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Integer>{
  CourseSession findById(int i);
}
