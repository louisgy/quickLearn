package com.quicklearn.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quicklearn.domain.TestOpportunity;

@Repository
public interface TestOpportunityRepository extends JpaRepository<TestOpportunity, Integer> {

}
