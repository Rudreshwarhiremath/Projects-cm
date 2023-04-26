package com.xworkz.pro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
@NamedQuery(name = "searchTechnology", query = "select ent from Technology ent where ent.teName=:techName or ent.teLangauge=:techLangauge or ent.teVersion=:techVersion or ent.teOwner=:techOwner or ent.teSupportFrom=:techSupportFrom or ent.teSupportTo=:techSupportTo or ent.teLicense=:techLicense or ent.teOpenSource=:techOpenSource or ent.teOsType=:techOsType and ent.userEntity.id=:tid")
public class Technology extends AbstractAudit {
	@Id
	@Column(name = "t_id")
	private int tId;

	@Column(name = "t_name")
	private String teName;

	@Column(name = "t_langauge")
	private String teLangauge;

	@Column(name = "t_version")
	private String teVersion;

	@Column(name = "t_owner")
	private String teOwner;

	@Column(name = "t_supportFrom")
	private String teSupportFrom;

	@Column(name = "t_supportTo")
	private String teSupportTo;

	@Column(name = "t_license")
	private String teLicense;

	@Column(name = "t_openSource")
	private String teOpenSource;

	@Column(name = "t_osType")
	private String teOsType;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private UserEntity userEntity;

}
