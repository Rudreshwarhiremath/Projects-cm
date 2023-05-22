package com.axis.lms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.lms.constants.Role;
import com.axis.lms.dto.ClassesDto;
import com.axis.lms.dto.CourseDto;
import com.axis.lms.dto.EnrollmentDto;
import com.axis.lms.dto.SubmissionsDto;
import com.axis.lms.dto.UserDto;
import com.axis.lms.service.AssignmentService;
import com.axis.lms.service.CourseService;
import com.axis.lms.service.EnrollmentService;
import com.axis.lms.service.ScheduleService;
import com.axis.lms.service.SubmissonService;
import com.axis.lms.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
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
	@Autowired
	private ScheduleService scheduleService;

	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public String userRegister(@RequestBody UserDto udto) {
		// udto.setRole(Role.STUDENT);
		this.userService.save(udto);
		return "UserRegestered Sucessfully";
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public String userLogin(@RequestParam String userName, @RequestParam String password) {
		UserDto udto = this.userService.login(userName, password);
		// model.addAttribute("user", udto.getUserId());
		if (udto.getRole().equals(Role.STUDENT)) {
			return "Login sucessfully as student";
		}
		if (udto.getRole().equals(Role.TEACHER)) {
			return "Login sucessfully as teacher";
		}
		if (udto.getRole().equals(Role.ADMIN)) {
			return "Login sucessfully as admin";
		}

		return "Login sucessfully";
	}

	@GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CourseDto> allCourses() {
		List<CourseDto> courseList = this.courseService.findAll();
		return courseList;

	}

	@PostMapping(value = "/enrole", produces = MediaType.APPLICATION_JSON_VALUE)
	public String courseEnrole(@RequestBody EnrollmentDto edto) {
		this.enrollmentService.save(edto);
		return "Enrolled sucessfully";
	}

	@GetMapping(value = "/classSchedule", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClassesDto> getSchedule(@RequestParam String userName) {
		System.out.println(userName);
		List<ClassesDto> classes = this.scheduleService.getSchedule(userName);
		return classes;
	}

	@GetMapping(value = "/getCoursesEnrolled", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCourseList(@RequestParam String userName) {
		System.out.println(userName);
		List<CourseDto> courseDtos = this.enrollmentService.enroledCourses(userName);
		List<String> courseList = new ArrayList<String>();
		for (CourseDto course : courseDtos) {
			String courseName = course.getCourseName();
			courseList.add(courseName);
		}
		return courseList;
	}
	@GetMapping(value = "/getGrades", produces = MediaType.APPLICATION_JSON_VALUE)
	public SubmissionsDto submissionsDto(@RequestParam String userName) {
		SubmissionsDto submissionsDto=this.submissonService.findBySubmission(userName);
		return submissionsDto;
	}
}
