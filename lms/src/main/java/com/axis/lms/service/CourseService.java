package com.axis.lms.service;

import java.util.List;

import com.axis.lms.dto.CourseDto;

public interface CourseService {
	boolean courseSave(CourseDto cdto);

	List<CourseDto> findAll();

}
