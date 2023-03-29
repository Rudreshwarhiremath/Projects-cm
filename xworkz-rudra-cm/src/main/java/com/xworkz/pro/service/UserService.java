package com.xworkz.pro.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.pro.dto.UserDTO;

public interface UserService {

	Set<ConstraintViolation<UserDTO>> validateAndSave(UserDTO userDTO);

	default List<UserDTO> findAll() {
		return Collections.emptyList();
	}
}
