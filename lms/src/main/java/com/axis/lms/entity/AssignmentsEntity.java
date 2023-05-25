package com.axis.lms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class AssignmentsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assignmentsId;
	// private int courseId;
	private String assignmentName;
	private LocalDate duedate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseId", referencedColumnName = "courseId")
	private CourseEntity courseEntity;
	@OneToMany(mappedBy = "assignmentsEntity", cascade = CascadeType.ALL)
	private List<SubmissionsEntity> submissionsEntity;

}
