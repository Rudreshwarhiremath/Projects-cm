package com.xworkz.pro.service;

import java.time.LocalDateTime;
import java.util.Iterator;
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
	public List<Technology> searchByTechName(String teName, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechName(teName, id);
		log.info("Search List" + list);
		return list;
	}

	@Override
	public List<Technology> searchByTechLanguage(String teLangauge, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechLanguage(teLangauge, id);
		log.info("Search List" + list);
		return list;
	}

	@Override
	public List<Technology> searchByTechLicense(String teLicense, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechLicense(teLicense, id);
		log.info("Search List" + list);
		return list;
	}

	@Override
	public List<Technology> searchByTechOpenSource(String teOpenSource, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechOpenSource(teOpenSource, id);
		log.info("Search List" + list);
		return list;
	}

	@Override
	public List<Technology> searchByTechOsType(String teOsType, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechOsType(teOsType, id);
		log.info("Search List" + list);
		return list;
	}

	@Override
	public List<Technology> searchByTechOwner(String teOwner, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechOwner(teOwner, id);
		log.info("Search List" + list);
		return list;
	}

	@Override
	public List<Technology> searchByTechSupportFrom(String teSupportFrom, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechSupportFrom(teSupportFrom, id);
		log.info("Search List" + list);
		return list;
	}

	@Override
	public List<Technology> searchByTechSupportTo(String teSupportTo, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechSupportTo(teSupportTo, id);
		log.info("Search List" + list);
		return list;
	}

	@Override
	public List<Technology> searchByTechVersion(String teVersion, String userId) {
		UserEntity entity = this.userRepositery.getByUser(userId);
		int id = entity.getId();
		List<Technology> list = userRepositery.searchByTechVersion(teVersion, id);
		log.info("Search List" + list);
		return list;
	}

}
