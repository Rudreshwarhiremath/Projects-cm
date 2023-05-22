package com.axis.lms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ClassesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classesId;
	//private int courseId;
	//private int teacherId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userId",referencedColumnName ="userId" )
	private UserEntity userEntity;
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "courseId",referencedColumnName = "courseId")
	private CourseEntity courseEntity;

}
