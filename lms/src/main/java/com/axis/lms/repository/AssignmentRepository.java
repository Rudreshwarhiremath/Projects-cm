package com.axis.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.lms.entity.AssignmentsEntity;

public interface AssignmentRepository extends JpaRepository<AssignmentsEntity, Integer> {
	AssignmentsEntity findByAssignmentName(String assignmentName);


}
