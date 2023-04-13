package com.xworkz.pro.controller;

import java.time.LocalTime;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.pro.dto.UserDTO;
import com.xworkz.pro.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController() {
		log.info("" + this.getClass().getSimpleName());
	}

	@PostMapping("/save")
	public String userInfo(UserDTO userDTO, Model model) {
		Set<ConstraintViolation<UserDTO>> violations = this.userService.validateAndSave(userDTO);

		if (violations != null && violations.isEmpty() && userDTO != null) {
			model.addAttribute("message", "Registration sucessfull");
			log.info("Running in no violations condition ");
			log.info("" + userDTO);
			return "signUp";
		}
		model.addAttribute("errors", violations);
		model.addAttribute("messag", "Registration failed");
		model.addAttribute("dto", userDTO);
		log.info("Running in  violations condition ");
		return "signUp";

	}

	@PostMapping("/signin")
	public String userSignIn(String userId, String password, Model model,HttpServletRequest request) {
		log.info("Running in userSignIn condition ");
		try {
			UserDTO udto = this.userService.userSignIn(userId, password);
			log.info("Login count" + udto.getLoginCount());
			if (udto.getLoginCount() >= 3) {
				model.addAttribute("msg", "Account locked Reset password");
				log.info("Acount locked due to wrong password entering 3 times");
				return "SignIn";
			}
			if (udto != null) {

				if (udto.getResetPassword() == true) {
					log.info("Running in ResetPassword true condition");
					if (!udto.getPasswordChangedTime().isAfter(LocalTime.now())) {
						log.info("Running in time warifying condition");
						model.addAttribute("msgs", "Time out plz try again");
						return "SignIn";
					}
					model.addAttribute("userID", udto.getUserId());
					log.info("Running in reset condition");
					log.info("ResetPassword---" + udto.getResetPassword());
					log.info("Timer-----" + udto.getPasswordChangedTime().isBefore(LocalTime.now()));
					return "updatePassword";
				}
				System.currentTimeMillis();
				log.info("User ID and password is matched");
			//	model.addAttribute("userID", udto.getUserId());//request scope
				HttpSession httpSession= request.getSession(true);
				httpSession.setAttribute("userID", udto.getUserId());
				return "LoginSucess";
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
		}
		log.info("UserID OR Password is not matching");
		model.addAttribute("match", "UserID OR Password is not matching");
		return "SignIn";

	}

	@PostMapping("/reset")
	public String reSetPassword(String email, Model model) {
		try {
			UserDTO udto = this.userService.reSetPassword(email);
			if (udto.getResetPassword() == true) {
				log.info("Password reset sucessful plz login with in 2 min with otp");
				model.addAttribute("msg", "Password reset sucessful plz login with in 2 min with otp");
				return "resetpassword";
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
		}
		return "resetpassword";

	}

	@PostMapping("/passwordUpdate")
	public String upDatePassword(String userId, String password, String confirmPassword) {
		log.info("Running in upDatePassword method");
		this.userService.updatePassword(userId, password, confirmPassword);
		return "sucess";
	}

}
