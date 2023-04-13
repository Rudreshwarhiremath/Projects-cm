package com.xworkz.pro.repositery;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import com.xworkz.pro.entity.UserEntity;

public interface UserRepositery {
	boolean save(UserEntity userEntity);

	default List<UserEntity> findAll() {
		return Collections.emptyList();
	}

	default UserEntity userSignIn(String userId) {
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
	
	boolean updatePassword(String userId, String password,Boolean resetPassword,LocalTime passwordChangedTime);

	boolean logincount(String userId, int count);
}
