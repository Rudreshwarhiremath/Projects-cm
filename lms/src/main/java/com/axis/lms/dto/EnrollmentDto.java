package com.axis.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnrollmentDto {
	private Integer enrollmentId;
	private String studentId;
	private String courseId;

}
