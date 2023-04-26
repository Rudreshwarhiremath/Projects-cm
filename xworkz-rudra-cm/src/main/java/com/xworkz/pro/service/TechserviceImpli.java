package com.xworkz.pro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.pro.dto.UserDTO;
import com.xworkz.pro.entity.Technology;
import com.xworkz.pro.entity.UserEntity;
import com.xworkz.pro.repositery.UserRepositery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TechserviceImpli implements Techservice {
	@Autowired
	private UserRepositery userRepositery;

	@Override
	public UserDTO updateTechnology(String userId, Technology technology, Model model) {
		UserEntity userEntity = this.userRepositery.getByUser(userId);
		List<Technology> list = userEntity.getTechnology();
		technology.setUserEntity(userEntity);
		technology.setCreatedBy(userId);
		technology.setCreatedDate(LocalDateTime.now());
		boolean save = this.userRepositery.saveTechnology(technology);
		log.info("Technology  " + save);
		return null;
	}

	@Override
	public List<Technology> technology(String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		List<Technology> list = entity.getTechnology();
		return list;
	}

	@Override
	public List<Technology> searchTechnology(String userId, String teName, String teLangauge, String teVersion,
			String teOwner, String teSupportFrom, String teSupportTo, String teLicense, String teOpenSource,
			String teOsType) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = this.userRepositery.searchTechnology(teName, teLangauge, teVersion, teOwner,
				teSupportFrom, teSupportTo, teLicense, teOpenSource, teOsType, id);
		log.info("Search List" + list);
		return list;
	}

}
