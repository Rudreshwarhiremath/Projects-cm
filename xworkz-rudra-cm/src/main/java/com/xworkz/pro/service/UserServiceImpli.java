package com.xworkz.pro.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.pro.dto.UserDTO;
import com.xworkz.pro.entity.UserEntity;
import com.xworkz.pro.repositery.UserRepositery;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpli implements UserService {
	@Autowired
	private UserRepositery userRepositery;

	private Set<ConstraintViolation<UserDTO>> validate(UserDTO userDto) {
		ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validationFactory.getValidator();
		Set<ConstraintViolation<UserDTO>> vailation = validator.validate(userDto);
		return vailation;
	}

	public UserServiceImpli() {
		log.info("" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<UserDTO>> validateAndSave(UserDTO userDTO) {
		Set<ConstraintViolation<UserDTO>> violations = validate(userDTO);
		if (violations != null && !violations.isEmpty()) {
			log.info("there is vailation in dto");
			return violations;
		}else {
		log.info("No violations procceding to save");
		UserEntity entity= new UserEntity();
		entity.setCreatedBy(userDTO.getUserId());
		entity.setCreatedDate(LocalDateTime.now());
		BeanUtils.copyProperties(userDTO, entity);
		boolean saved=this.userRepositery.save(entity);
		log.info(""+saved);
			}
		return Collections.emptySet();
		}
}


