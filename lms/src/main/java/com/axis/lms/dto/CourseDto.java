package com.axis.lms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDto {
	private int courseId;
	private String CourseName;
	private String teacherId;
	private LocalDate startDate;
	private LocalDate endDate;

}
