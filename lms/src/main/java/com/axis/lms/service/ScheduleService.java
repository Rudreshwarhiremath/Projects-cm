package com.axis.lms.service;

import java.util.List;

import com.axis.lms.dto.ClassesDto;

public interface ScheduleService {
	boolean save(ClassesDto classesDto);
	
	List<ClassesDto> getSchedule(String userName);

}
