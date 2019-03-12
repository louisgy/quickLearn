package com.quicklearn.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quicklearn.domain.Test;


@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
	Test findById(int i);
}
