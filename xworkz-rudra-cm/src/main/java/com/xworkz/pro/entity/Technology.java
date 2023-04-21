package com.xworkz.pro.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "technologies")
public class Technology extends AbstractAudit {
	@Id
	@Column(name = "t_id")
	private int t_id;

	@Column(name = "t_name")
	private String t_name;

	@Column(name = "t_langauge")
	private String t_langauge;

	@Column(name = "t_version")
	private String t_version;

	@Column(name = "t_owner")
	private String t_owner;

	@Column(name = "t_supportFrom")
	private String t_supportFrom;

	@Column(name = "t_supportTo")
	private String t_supportTo;

	@Column(name = "t_license")
	private String t_license;

	@Column(name = "t_openSource")
	private String t_openSource;

	@Column(name = "t_osType")
	private String t_osType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private UserEntity userEntity;

}
