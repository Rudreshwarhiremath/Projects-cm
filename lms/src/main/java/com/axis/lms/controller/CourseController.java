package com.axis.lms.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.lms.dto.ClassesDto;
import com.axis.lms.dto.CourseDto;
import com.axis.lms.dto.UserDto;
import com.axis.lms.service.AssignmentService;
import com.axis.lms.service.CourseService;
import com.axis.lms.service.EnrollmentService;
import com.axis.lms.service.ScheduleService;
import com.axis.lms.service.SubmissonService;
import com.axis.lms.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:3000")
public class CourseController {
	@Autowired
	private UserService userService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private EnrollmentService enrollmentService;
	@Autowired
	private AssignmentService assignmentService;
	@Autowired
	private ScheduleService scheduleService;
	// @Autowired
	// private MessagesService messagesService;
	@Autowired
	private SubmissonService submissonService;

	@GetMapping(value = "/set", produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseDto getCourse() {
		CourseDto cdto = new CourseDto();
		cdto.setCourseId(1);
		cdto.setCourseName("AWS");
		cdto.setEndDate(LocalDate.of(2024, 02, 01));
		cdto.setStartDate(LocalDate.now());
		return cdto;
	}

	@PostMapping(value = "/addCourse", produces = MediaType.APPLICATION_JSON_VALUE)
	public String createCourse(@RequestBody CourseDto cdto) {
		this.courseService.courseSave(cdto);
		System.out.println(cdto.getTeacherId());
		return "course Added sucessfully";
	}

	@GetMapping(value = "/enrolList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> enrolled(@RequestParam String courseName) {
		System.out.println(courseName);
		List<UserDto> udtos = this.enrollmentService.enrollList(courseName);
		List<String>users=new ArrayList<String>();
		for (UserDto userDto : udtos) {
			String userName=userDto.getUserName();
			users.add(userName);
		}
		return users;
	}
//	@GetMapping(value = "/schedule",produces = MediaType.APPLICATION_JSON_VALUE)
//	public ClassesDto classesDto() {
//		ClassesDto classesDto1=new ClassesDto();
//		classesDto1.setClassesId(0);
//		classesDto1.setCourseId("Java");
//		classesDto1.setEndTime(LocalDateTime.now());
//		classesDto1.setStartTime(LocalDateTime.now());
//		classesDto1.setTeacherId("Suhas");
//		return classesDto1;
//	}
	@PostMapping(value = "/schedule", produces = MediaType.APPLICATION_JSON_VALUE)
	public String classes(@RequestBody ClassesDto classesDto) {
		this.scheduleService.save(classesDto);
		return "Classes  Scheduled sucessfully";
	}
//@PostMapping(value = "/msgs",produces = MediaType.APPLICATION_JSON_VALUE)
//	public String msgs(@RequestBody MessagesDto mdto) {
//		this.messagesService.save(mdto);
//		return "message sent sucessfully";
//	}
}
