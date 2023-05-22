package com.axis.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.lms.dto.AssignmentDto;
import com.axis.lms.dto.ClassesDto;
import com.axis.lms.dto.SubmissionsDto;
import com.axis.lms.service.AssignmentService;
import com.axis.lms.service.CourseService;
import com.axis.lms.service.EnrollmentService;
import com.axis.lms.service.SubmissonService;
import com.axis.lms.service.UserService;

@RestController
@RequestMapping("/")
public class AssignmentController {
	@Autowired
	private UserService userService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private EnrollmentService enrollmentService;
	@Autowired
	private AssignmentService assignmentService;
//	@Autowired
//	private MessagesService messagesService;
	@Autowired
	private SubmissonService submissonService;

	@PostMapping(value = "/assign", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAssignment(@RequestBody AssignmentDto adto) {
		this.assignmentService.save(adto);
		return "Assignment assigned sucessfully";
	}

	@PostMapping(value = "/submission", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sdto(@RequestBody SubmissionsDto adto) {
		System.out.println(adto.getAssignmentId());
		this.submissonService.save(adto);
		return "Submited sucessfully";
	}

}
