package com.axis.lms.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class SubmissionsDto {
	
	private int submissionsId;
	private String assignmentId;
	private String studentId;
	private float grade;
	private String feedBack;

}
