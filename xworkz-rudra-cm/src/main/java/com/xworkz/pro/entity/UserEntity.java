package com.xworkz.pro.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xworkz.pro.dto.AbstractAudit;

import lombok.Data;

@Data
@Entity
@Table(name = "userinformation")
@NamedQuery(name = "find",query = "select ent from UserEntity ent")
@NamedQuery(name = "userId",query = "select count(*) from  UserEntity ent where ent.userId=:userBy")
@NamedQuery(name = "emailId",query = "select count(*) from  UserEntity ent where ent.email=:emailBy")
@NamedQuery(name = "mobileId",query = "select count(*) from  UserEntity ent where ent.mobile=:mobileBy")
public class UserEntity {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "userId")
	private String userId;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile")
	private long mobile;
	@Column(name = "password")
	private String password;
	@Column(name = "agreement")
	private Boolean agreement;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "createdDate")
	private LocalDateTime createdDate;
	@Column(name = "updatedBy")
	private String updatedBy;
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;

}
