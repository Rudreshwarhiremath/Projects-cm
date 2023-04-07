package com.xworkz.pro.controller;

import java.util.Set;

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
			log.info("" + userDTO);
			return "signUp";
		}
		model.addAttribute("errors", violations);
		model.addAttribute("messag", "Registration failed");

		return "signUp";

	}

	@PostMapping("/signin")
	public String userSignIn(String userId, String password, Model model) {
		try {
			UserDTO udto = this.userService.userSignIn(userId, password);
			log.info("Login count" + udto.getLoginCount());
			if (udto.getLoginCount() >= 3) {
				model.addAttribute("msg", "Account locked Reset password");
				return "SignIn";
			}
			if (udto != null) {

				if (udto.getResetPassword()==true) {
					model.addAttribute("userID", udto.getUserId());
					return "updatePassword";
				}
				log.info("User ID and password is matched");
				model.addAttribute("userID", udto.getUserId());
				return "LoginSucess";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}

		model.addAttribute("match", "UserID OR Password is not matching");
		return "SignIn";

	}

	@PostMapping("/reset")
	public String reSetPassword(String email,Model model) {
		UserDTO udto = this.userService.reSetPassword(email);
		if(udto.getResetPassword()==true) {
			model.addAttribute("msg","Password reset sucessful plz login");
			return "resetpassword";
		}
		return "resetpassword";
	}
	@PostMapping("/passwordUpdate")
	public String upDatePassword(String userId, String password,String confirmPassword) {
		this.userService.updatePassword(userId, password, confirmPassword);
		return "sucess";
	}

}
