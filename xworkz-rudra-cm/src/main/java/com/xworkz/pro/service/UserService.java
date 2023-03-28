package com.xworkz.pro.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.pro.dto.UserDTO;

public interface UserService {

	Set<ConstraintViolation<UserDTO>> validateAndSave(UserDTO userDTO);
}
