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

		List<UserDTO> dtoList = this.userService.findAll();
		for (UserDTO dto : dtoList) {
			System.out.println(dto);
			if (userDTO.getUserId().equals(dto.getUserId())) {
				model.addAttribute("userIdExesist", "UserId already Existed");
				return "signUp";
			} else if (userDTO.getEmail().equals(dto.getEmail())) {
				model.addAttribute("emailIdExesist", "Email ID already Existed");
				return "signUp";
			} else if (userDTO.getMobile().equals(dto.getMobile())) {
				model.addAttribute("mobileNumberExesist", "Mobile Number already Existed");
				return "signUp";
			}

		}
		if (userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			Set<ConstraintViolation<UserDTO>> violations = this.userService.validateAndSave(userDTO);

			if (violations.isEmpty()) {
				model.addAttribute("message", "data saved sucessfull");
				log.info("" + userDTO);
				return "signUp";

			} else {
				model.addAttribute("errors", violations);
				model.addAttribute("messag", "data not saved");
			}
			return "signUp";
		} else {
			model.addAttribute("password", "Password and Confirmpassword must be same");
		}

		return "signUp";
	}

}
