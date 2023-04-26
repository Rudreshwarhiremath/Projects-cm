package com.xworkz.pro.service;

import java.util.List;

import org.springframework.ui.Model;

import com.xworkz.pro.dto.UserDTO;
import com.xworkz.pro.entity.Technology;

public interface Techservice {
	default UserDTO updateTechnology(String userId, Technology technology, Model model) {
		return null;
	}

	default List<Technology> technology(String userId) {
		return null;
	}

	default List<Technology> searchTechnology(String userId, String teName, String teLangauge, String teVersion,
			String teOwner, String teSupportFrom, String teSupportTo, String teLicense, String teOpenSource,
			String teOsType) {
		return null;

	}

}
