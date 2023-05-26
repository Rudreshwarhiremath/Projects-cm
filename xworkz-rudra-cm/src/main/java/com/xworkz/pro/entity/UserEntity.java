package com.xworkz.pro.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userinformation")
@NamedQuery(name = "find", query = "select ent from UserEntity ent")
@NamedQuery(name = "userId", query = "select count(*) from  UserEntity ent where ent.userId=:userBy")
@NamedQuery(name = "emailId", query = "select count(*) from  UserEntity ent where ent.email=:emailBy")
@NamedQuery(name = "mobileId", query = "select count(*) from  UserEntity ent where ent.mobile=:mobileBy")
@NamedQuery(name = "user", query = "select ent from UserEntity ent where ent.userId=:ui")
@NamedQuery(name = "users", query = "select ent from UserEntity ent where ent.userId=:uis")
@NamedQuery(name = "emailid", query = "select ent from UserEntity ent where ent.email=:ei")
//"update Employee emp set emp.surname=:surname where emp.name=:name\"")
@NamedQuery(name = "updateLoginCount", query = "update UserEntity ent set ent.loginCount=:count where ent.userId=:userID")
@NamedQuery(name = "updatePassword", query = "update UserEntity ent set ent.password=:up , ent.resetPassword=:urp ,ent.passwordChangedTime=:pct where ent.userId=:uu")
public class UserEntity extends AbstractAudit implements Serializable {
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

	@Column(name = "logincount")
	private int loginCount;

	private Boolean resetPassword;

	@Column(name = "passwordChangedTime")
	private LocalTime passwordChangedTime;

	private String picName;

	@OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Technology> technology;

}
