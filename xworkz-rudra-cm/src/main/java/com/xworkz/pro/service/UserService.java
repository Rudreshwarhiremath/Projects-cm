package com.xworkz.pro.service;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.pro.dto.UserDTO;

public interface UserService {

	Set<ConstraintViolation<UserDTO>> validateAndSave(UserDTO userDTO);
	
	default UserDTO userSignIn(String userId, String password) {
		return null;
	}

	default List<UserDTO> findAll() {
		return Collections.emptyList();
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long mobile) {
		return null;
	}

	default Long findByUser(String user) {
		return null;
	}
	default UserDTO reSetPassword(String email) {
		return null;
	}
	default UserDTO updatePassword(String userId, String password,String confirmPassword) {
		return null;
	}
	default UserDTO updateProfile(String userId,String email,Long mobile,String path) {
		return null;
	}
	

	boolean sendMail(String email,String text);
	
}
