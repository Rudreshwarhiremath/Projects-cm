package com.xworkz.pro.controller;

import java.util.Iterator;
import java.util.List;
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
		UserDTO udto = this.userService.udto(userId, password);
		if (udto!=null) {
			log.info("User ID and password is matched");
			model.addAttribute("userID",udto.getUserId());
			return "LoginSucess";
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			model.addAttribute("match", "UserID OR Password is not matching");
			return "SignIn";			

	}

}
