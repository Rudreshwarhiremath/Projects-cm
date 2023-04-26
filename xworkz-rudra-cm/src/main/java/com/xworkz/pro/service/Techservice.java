package com.xworkz.pro.service;

import java.util.List;

import org.springframework.ui.Model;

import com.xworkz.pro.dto.UserDTO;
import com.xworkz.pro.entity.Technology;

public interface Techservice {
	default UserDTO updateTechnology(String userId, Technology technology, Model model ) {
		return null;
	}

	default List<Technology> technology(String userId) {
		return null;
	}

	default List<Technology> searchByTechName(String teName, String userId) {
		return null;

	}

	default List<Technology> searchByTechLanguage(String teLangauge, String userId) {
		return null;

	}
	default List<Technology> searchByTechVersion(String teVersion, String userId) {
		return null;

	}
	default List<Technology> searchByTechSupportFrom(String teSupportFrom, String userId) {
		return null;

	}
	default List<Technology> searchByTechSupportTo(String teSupportTo, String userId) {
		return null;

	}
	default List<Technology> searchByTechOwner(String teOwner, String userId) {
		return null;

	}
	default List<Technology> searchByTechLicense(String teLicense, String userId) {
		return null;

	}
	default List<Technology> searchByTechOpenSource(String teOpenSource, String userId) {
		return null;

	}
	default List<Technology> searchByTechOsType(String teOsType, String userId) {
		return null;

	}

}
