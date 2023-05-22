package com.axis.lms.dto;


import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AssignmentDto {
		
	private int assignmentsId;
	private String courseId;
	private String assignmentName;
	private LocalDate duedate;

}


