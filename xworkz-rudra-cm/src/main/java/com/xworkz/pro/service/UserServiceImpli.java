package com.xworkz.pro.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
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
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;

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
		Long emailCount = this.userRepositery.findByEmail(userDTO.getEmail());
		Long userCount = this.userRepositery.findByUser(userDTO.getUserId());
		Long mobileCount = this.userRepositery.findByMobile(userDTO.getMobile());
		log.error("emailCount-" + emailCount);
		log.error("userCount-" + userCount);
		log.error("mobileCount-" + mobileCount);

		Set<ConstraintViolation<UserDTO>> violations = validate(userDTO);
		if (violations != null && !violations.isEmpty()) {
			log.info("there is Violation in dto");
			return violations;
		}
		if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			log.info("Password is not matching");
			return null;
		}
		if (emailCount == 0 && userCount == 0 && mobileCount == 0) {
			log.info("No Violations procceding to save");

			UserEntity entity = new UserEntity();
			entity.setUserId(userDTO.getUserId());
			entity.setEmail(userDTO.getEmail());
			entity.setMobile(userDTO.getMobile());
			entity.setAgreement(userDTO.getAgreement());
			entity.setCreatedBy(userDTO.getUserId());
			entity.setCreatedDate(LocalDateTime.now());
			entity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			entity.setResetPassword(false);
			entity.setPasswordChangedTime(LocalTime.of(0, 0, 0));
			// BeanUtils.copyProperties(userDTO, entity);

			boolean saved = this.userRepositery.save(entity);
			log.info("Saved in Entity-" + saved);

			if (saved) {
				boolean sent = this.sendMail(userDTO.getEmail(), "Thanks for registration");
				log.info("Email sent -:" + sent);

			}

		}
		return Collections.emptySet();
	}

	@Override
	public UserDTO userSignIn(String userId, String password) {
		UserEntity entity = this.userRepositery.userSignIn(userId);
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(entity, dto);
		log.info("matching--" + passwordEncoder.matches(password, entity.getPassword()));
		log.info("Time matching--" + entity.getPasswordChangedTime().isBefore(LocalTime.now()));
		log.info("Now Present Time--" + LocalTime.now());
		log.info("PasswordChangedTime--" + entity.getPasswordChangedTime());

//		if (entity.getResetPassword() == true && LocalTime.now().isBefore(entity.getPasswordChangedTime())) {
//			log.info("Running in Time matching");
//			return dto;
//		}

		log.info("Time " + LocalTime.now().isBefore(entity.getPasswordChangedTime()));
		if (entity.getLoginCount() >= 3) {
			log.info("Running in Login count condition");
			return dto;
		}

		if (dto.getUserId().equals(userId) && passwordEncoder.matches(password, entity.getPassword())) {
			log.info("Running userId matching and password matching");
			return dto;
		} else {
			this.userRepositery.logincount(userId, entity.getLoginCount() + 1);
			log.info("count of login" + entity.getLoginCount() + 1);
			return null;
		}
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
		Long emailcount = this.userRepositery.findByEmail(email);
		log.error("Find  by Email count");
		return emailcount;
	}

	@Override
	public Long findByMobile(Long mobile) {
		Long mobilecount = this.userRepositery.findByMobile(mobile);
		log.error("Find  by mobile count");
		return mobilecount;
	}

	@Override
	public Long findByUser(String user) {
		log.error("Find  by user count");
		Long userCount = this.userRepositery.findByUser(user);
		return userCount;
	}

	@Override
	public UserDTO reSetPassword(String email) {
		log.info("Running in reSetPassword");
		String reSetPassword = DefaultPasswordGenerator.generate(6);
		log.info("ReSetd password--" + reSetPassword);
		UserEntity entity = this.userRepositery.reSetPassword(email);
		if (entity != null) {
			log.info("entity found for email" + email);
			entity.setPassword(passwordEncoder.encode(reSetPassword));
			entity.setUpdatedBy("System");
			entity.setUpdatedDate(LocalDateTime.now());
			entity.setLoginCount(0);
			entity.setResetPassword(true);
			entity.setPasswordChangedTime(LocalTime.now().plusSeconds(120));
			boolean update = this.userRepositery.update(entity);
			if (update) {
				sendMail(entity.getEmail(),
						"Your  reseted password is-> " + reSetPassword + "Plz log in again with in 2 min with this password ");
			}
			log.info("Updated---" + update);
			UserDTO updatedDto = new UserDTO();
			BeanUtils.copyProperties(entity, updatedDto);

			return updatedDto;
		}
		log.info("entity not found for email" + email);
		return UserService.super.reSetPassword(email);
	}

	@Override
	public UserDTO updatePassword(String userId, String password, String confirmPassword) {
		log.info("Running in updating password condition");
		if (password.equals(confirmPassword)) {
			boolean passwordUpdated = this.userRepositery.updatePassword(userId, passwordEncoder.encode(password),
					false, LocalTime.of(0, 0, 0));
			log.info("passwordUpdated--" + passwordUpdated);
		}

		return UserService.super.updatePassword(userId, password, confirmPassword);
	}

	@Override
	public boolean sendMail(String email, String text) {
		String portNumber = "587";// 485,587,25
		String hostName = "smtp.office365.com";
		String fromEmail = "rudraproject26@outlook.com";
		String password = "rudra@2026";
		String to = email;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration  Completed");
			// message.setText("Thanks for registration and your password is" +
			// reSetPassword);
			message.setText(text);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("mail sent sucessfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}

	public final static class DefaultPasswordGenerator {
		private static final String[] charCategories = new String[] { "abcdefghijklmnopqrstuvwxyz",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789" };

		public static String generate(int length) {
			StringBuilder password = new StringBuilder(length);
			Random random = new Random(System.nanoTime());

			for (int i = 0; i < length; i++) {
				String charCategory = charCategories[random.nextInt(charCategories.length)];
				int position = random.nextInt(charCategory.length());
				password.append(charCategory.charAt(position));
			}

			return new String(password);
		}
//		String password = DefaultPasswordGenerator.generate(6);[use this reference to generate the password]
	}

}
