package com.axis.lms.service;

import java.util.List;

import com.axis.lms.dto.CourseDto;
import com.axis.lms.dto.EnrollmentDto;
import com.axis.lms.dto.UserDto;

public interface EnrollmentService {
	boolean save(EnrollmentDto edto);

	List<UserDto> enrollList(String courseName);
	
	List<CourseDto> enroledCourses(String userName);
	
}
