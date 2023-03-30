package com.xworkz.pro.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
		if (userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			Set<ConstraintViolation<UserDTO>> violations = validate(userDTO);
			if (violations != null && !violations.isEmpty()) {
				log.info("there is vailation in dto");
				return violations;
			} else {
				log.info("No violations procceding to save");

				UserEntity entity = new UserEntity();
				entity.setCreatedBy(userDTO.getUserId());
				entity.setCreatedDate(LocalDateTime.now());
				BeanUtils.copyProperties(userDTO, entity);
				boolean saved = this.userRepositery.save(entity);
				log.info("" + saved);
			}
		}
		return Collections.emptySet();
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserEntity> userEntity = this.userRepositery.findAll();
		List<UserDTO> lists = new ArrayList<UserDTO>();
		for (UserEntity entity : userEntity) {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(entity, dto);
			lists.add(dto);

		}
		return lists;
	}

	@Override
	public Long findByEmail(String email) {
		Long email1 = this.userRepositery.findByEmail(email);
		log.error("Find  by Email");
		return email1;
	}

	@Override
	public Long findByMobile(Long mobile) {
		Long count = this.userRepositery.findByMobile(mobile);
		return count;
	}

	@Override
	public Long findByUser(String user) {
		Long userCount = this.userRepositery.findByUser(user);
		return userCount;
	}

	@Override
	public boolean sendMail(String to) {
		String portNumber = "587";// 485,587,25
		String hostName = "smtp.gmail.com";
		String fromEmail = "";
		String password = "";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.sttartls.enable", true);

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}

		});
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Mail Subject");
			message.setText("Thanks for registration");
			String msg = "This is my first email using JavaMailer";

			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
