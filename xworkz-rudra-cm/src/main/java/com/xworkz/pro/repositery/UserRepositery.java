package com.xworkz.pro.repositery;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import com.sun.el.stream.Optional;
import com.xworkz.pro.entity.Technology;
import com.xworkz.pro.entity.UserEntity;

public interface UserRepositery {
	boolean save(UserEntity userEntity);

	default List<UserEntity> findAll() {
		return Collections.emptyList();
	}

	default UserEntity getByUser(String userId) {
		return null;
	}

	default Long findByUser(String user) {
		return null;
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long number) {
		return null;
	}

	default UserEntity reSetPassword(String email) {
		return null;
	}

	boolean update(UserEntity userEntity);

	boolean updatePassword(String userId, String password, Boolean resetPassword, LocalTime passwordChangedTime);

	boolean logincount(String userId, int count);

	boolean saveTechnology(Technology technology);

	default List<Technology> viewTechnology(String users) {
		return null;

	}

	default List<Technology> searchTechnology(String teName, String teLangauge, String teVersion, String teOwner,
			String teSupportFrom, String teSupportTo, String teLicense, String teOpenSource, String teOsType, int id) {
		return null;

	}

}
