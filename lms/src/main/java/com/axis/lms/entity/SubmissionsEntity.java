package com.axis.lms.entity;

import javax.persistence.CascadeType;
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
public class SubmissionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int submissionsId;
	//private int assignmentsId;
	//private int studentId;
	private float grade;
	private String feedBack;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "assignmentsId", referencedColumnName = "assignmentsId")
	private AssignmentsEntity assignmentsEntity;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private UserEntity userEntity;

}
