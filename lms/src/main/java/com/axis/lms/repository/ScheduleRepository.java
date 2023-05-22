package com.axis.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.lms.entity.ClassesEntity;
import com.axis.lms.entity.CourseEntity;

public interface ScheduleRepository extends JpaRepository<ClassesEntity, Integer> {
	List<ClassesEntity> findByCourseEntity(CourseEntity courseEntity);

}
