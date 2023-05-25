package com.axis.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.lms.entity.MessagesEntity;

public interface MessageRepositery extends JpaRepository<MessagesEntity, Integer> {
	
	MessagesEntity findByReciverId(long id);

}
