package com.axis.lms.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClassesDto {
	private Integer classesId;
	private String courseId;
	private String teacherId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

}
