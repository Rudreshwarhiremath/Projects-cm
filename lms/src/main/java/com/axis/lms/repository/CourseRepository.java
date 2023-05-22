package com.axis.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.lms.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
	CourseEntity findByCourseName(String courseName);

}
