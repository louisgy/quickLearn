package com.quicklearn.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.quicklearn.domain.Enrollment;
import com.quicklearn.domain.EnrollmentId;



@Component
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId>{

}