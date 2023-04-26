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
@NamedQuery(name = "searchByTechName", query = "select ent from Technology ent where ent.teName=:techName and ent.userEntity.id=:tid")
@NamedQuery(name = "searchByTechLangauge", query = "select ent from Technology ent where ent.teLangauge=:techLangauge and ent.userEntity.id=:taid")
@NamedQuery(name = "searchByTechVersion", query = "select ent from Technology ent where ent.teVersion=:techVersion and ent.userEntity.id=:thid")
@NamedQuery(name = "searchByTechOwner", query = "select ent from Technology ent where ent.teOwner=:techOwner and ent.userEntity.id=:teid")
@NamedQuery(name = "searchByTechSupportFrom", query = "select ent from Technology ent where ent.teSupportFrom=:techSupportFrom and ent.userEntity.id=:tfid")
@NamedQuery(name = "searchByTechSupportTo", query = "select ent from Technology ent where ent.teSupportTo=:techSupportTo and ent.userEntity.id=:tgid")
@NamedQuery(name = "searchByTechLicense", query = "select ent from Technology ent where ent.teLicense=:techLicense and ent.userEntity.id=:tbid")
@NamedQuery(name = "searchByTechOpenSource", query = "select ent from Technology ent where ent.teOpenSource=:techOpenSource and ent.userEntity.id=:tcid")
@NamedQuery(name = "searchByTechOsType", query = "select ent from Technology ent where ent.teOsType=:techOsType and ent.userEntity.id=:tdid")

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
