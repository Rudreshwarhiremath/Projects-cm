package com.axis.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.lms.entity.SubmissionsEntity;
import com.axis.lms.entity.UserEntity;

public interface SubmissionRepositery extends JpaRepository<SubmissionsEntity, Integer> {

	SubmissionsEntity findByUserEntity(UserEntity userEntity);

}
