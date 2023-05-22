package com.axis.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.lms.entity.CourseEntity;
import com.axis.lms.entity.EnrollmentEntity;
import com.axis.lms.entity.UserEntity;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Integer> {
	List<EnrollmentEntity> findByCourseEntity(CourseEntity courseEntity);
	
	List<EnrollmentEntity> findByUserEntity(UserEntity UserEntity);


}
