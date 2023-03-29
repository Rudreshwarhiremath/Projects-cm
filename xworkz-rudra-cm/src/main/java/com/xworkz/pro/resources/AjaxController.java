package com.xworkz.pro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.pro.dto.UserDTO;
import com.xworkz.pro.service.UserService;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@RestController
@Slf4j
@RequestMapping("/")
public class AjaxController {

	@Autowired
	private UserService userService;

	public AjaxController() {
		log.info("" + this.getClass().getSimpleName());
	}

	@GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email) {
		List<UserDTO> dtoList = this.userService.findAll();
		System.err.println(email);
		for (UserDTO dto : dtoList) {
			if (email.equals(dto.getEmail())) {
				System.err.println("Running in equals condition");
				return "Email id exsist";
			}
		}
		return "";
	}

	@GetMapping(value = "/userName/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onUser(@PathVariable String user) {
		List<UserDTO> dtoList = this.userService.findAll();
		System.err.println(user);
		for (UserDTO dto : dtoList) {
			if (user.equals(dto.getUserId())) {
				System.err.println("Running in equals condition");
				return "UserID exsist";
			}
		}
		return "";
	}

	@GetMapping(value = "/mobile/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long number) {
		List<UserDTO> dtoList = this.userService.findAll();
		System.err.println(number);
		for (UserDTO dto : dtoList) {
			if (number.equals(dto.getMobile())) {
				System.err.println("Running in equals condition");
				return "Mobile Number exsist";
			}
		}
		return "";
	}
}
