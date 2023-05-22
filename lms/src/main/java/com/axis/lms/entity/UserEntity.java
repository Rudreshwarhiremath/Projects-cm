package com.axis.lms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.axis.lms.constants.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@Column(unique = true)
	private String userName;
	private String password;
	private Role role;
	@OneToMany(mappedBy = "userEntity",  cascade = CascadeType.ALL)
	private List<EnrollmentEntity> enrolmententity;
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private List<SubmissionsEntity> submissionsEntity;
	@OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ClassesEntity> classesEntity;
	@OneToOne(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumns({
        @JoinColumn(name="senderId", referencedColumnName="userId"),
        @JoinColumn(name="reciverId", referencedColumnName="userId")
    })
	private MessagesEntity messagesEntity;
	@OneToOne(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CourseEntity courseEntities;
}
