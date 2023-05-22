package com.axis.lms.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.lms.dto.AssignmentDto;
import com.axis.lms.entity.AssignmentsEntity;
import com.axis.lms.entity.CourseEntity;
import com.axis.lms.repository.AssignmentRepository;
import com.axis.lms.repository.CourseRepository;

@Service
public class AssignmentServiceImpl implements AssignmentService {
	@Autowired
	private AssignmentRepository assignmentRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public boolean save(AssignmentDto assignmentDto) {
		CourseEntity courseEntity=this.courseRepository.findByCourseName(assignmentDto.getCourseId());
		AssignmentsEntity assignmentsEntity = new AssignmentsEntity();
		assignmentsEntity.setCourseEntity(courseEntity);
		BeanUtils.copyProperties(assignmentDto, assignmentsEntity);
		this.assignmentRepository.save(assignmentsEntity);
		return true;
	}

}
