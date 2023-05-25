package com.axis.lms.service;

import java.util.List;

import com.axis.lms.dto.SubmissionsDto;

public interface SubmissonService {
	boolean save(SubmissionsDto submissionsDto);

	List<SubmissionsDto> findBySubmission(String userName);
}
