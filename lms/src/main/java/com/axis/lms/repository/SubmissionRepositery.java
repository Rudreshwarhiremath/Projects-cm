package com.axis.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.lms.entity.SubmissionsEntity;
import com.axis.lms.entity.UserEntity;

public interface SubmissionRepositery extends JpaRepository<SubmissionsEntity, Integer> {

	List<SubmissionsEntity> findByUserEntity(UserEntity userEntity);

}
