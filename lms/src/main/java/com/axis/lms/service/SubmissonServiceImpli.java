package com.axis.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.lms.dto.SubmissionsDto;
import com.axis.lms.entity.AssignmentsEntity;
import com.axis.lms.entity.SubmissionsEntity;
import com.axis.lms.entity.UserEntity;
import com.axis.lms.repository.AssignmentRepository;
import com.axis.lms.repository.SubmissionRepositery;
import com.axis.lms.repository.UserRepository;

@Service
public class SubmissonServiceImpli implements SubmissonService {
	@Autowired
	private SubmissionRepositery submissionRepositery;
	@Autowired
	private AssignmentRepository assignmentRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean save(SubmissionsDto submissionsDto) {
		AssignmentsEntity assignmentsEntity = this.assignmentRepository
				.findByAssignmentName(submissionsDto.getAssignmentId());
		System.out.println(submissionsDto.getAssignmentId());
		// System.out.println(assignmentsEntity.getAssignmentsId());
		UserEntity userEntity = this.userRepository.findByUserName(submissionsDto.getStudentId());
		SubmissionsEntity submissionsEntity = new SubmissionsEntity();
		submissionsEntity.setAssignmentsEntity(assignmentsEntity);
		submissionsEntity.setUserEntity(userEntity);
		BeanUtils.copyProperties(submissionsDto, submissionsEntity);
		this.submissionRepositery.save(submissionsEntity);
		return true;
	}

	@Override
	public List<SubmissionsDto> findBySubmission(String userName) {
		UserEntity userEntity = this.userRepository.findByUserName(userName);
		List<SubmissionsEntity> submissionsEntity = this.submissionRepositery.findByUserEntity(userEntity);
		List<SubmissionsDto> submissionsDto = new ArrayList<SubmissionsDto>();
		for (SubmissionsEntity submissionsEntity2 : submissionsEntity) {

			SubmissionsDto submissionsDto1 = new SubmissionsDto();
			submissionsDto1.setStudentId(submissionsEntity2.getUserEntity().getUserName());
			submissionsDto1.setGrade(submissionsEntity2.getGrade());
			submissionsDto1.setFeedBack(submissionsEntity2.getFeedBack());
			submissionsDto1.setAssignmentId(submissionsEntity2.getAssignmentsEntity().getAssignmentName());
			submissionsDto.add(submissionsDto1);
		}
		return submissionsDto;
	}
}
