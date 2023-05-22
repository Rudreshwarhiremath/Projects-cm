package com.axis.lms.service;

import com.axis.lms.dto.SubmissionsDto;

public interface SubmissonService {
	boolean save(SubmissionsDto submissionsDto);

	SubmissionsDto findBySubmission(String userName);
}
