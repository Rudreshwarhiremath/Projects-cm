package com.axis.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.lms.dto.CourseDto;
import com.axis.lms.entity.CourseEntity;
import com.axis.lms.entity.UserEntity;
import com.axis.lms.repository.CourseRepository;
import com.axis.lms.repository.UserRepository;

@Service
public class CourseServiceImpli implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<CourseDto> findAll() {
		List<CourseEntity> centity = this.courseRepository.findAll();
		List<CourseDto> cdto = new ArrayList<CourseDto>();
		for (CourseEntity courseEntity : centity) {
			CourseDto codto = new CourseDto();
			BeanUtils.copyProperties(courseEntity, codto);
			cdto.add(codto);

		}
		return cdto;
	}

	@Override
	public boolean courseSave(CourseDto cdto) {
		CourseEntity centity = new CourseEntity();
		System.out.println(cdto.getCourseName());
		String userName=cdto.getTeacherId();
		BeanUtils.copyProperties(cdto, centity);
		UserEntity uEntity=this.userRepository.findByUserName(userName);
//		centity.setCourseName(cdto.getCourseName());
//		centity.setTeacherId(cdto.getTeacherId());
//		centity.setStartDate(cdto.getStartDate());
//		centity.setEndDate(cdto.getEndDate());
		centity.setUserEntity(uEntity);
		this.courseRepository.save(centity);
		return true;
	}

}
