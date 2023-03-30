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
		Long dbEmail = this.userService.findByEmail(email);
		System.err.println(dbEmail);

		if (dbEmail == 0) {
			System.err.println("Running in equals condition");
			return "";
		} else {
			return "Email id exsist";
		}
	}

	@GetMapping(value = "/userName/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onUser(@PathVariable String user) {
		Long dbUser = this.userService.findByUser(user);
		System.err.println(dbUser);

		if (dbUser == 0) {
			System.err.println("Running in equals condition");
			return "";

		} else {
			return "UserID exsist";
		}
	}

	@GetMapping(value = "/mobile/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long number) {
		Long dbNumber = this.userService.findByMobile(number);
		System.err.println(dbNumber);

		if (dbNumber == 0) {
			System.err.println("Running in equals condition");
			return "";

		} else {
			return "Mobile Number exsist";
		}
	}

	@GetMapping(value = "/dto", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO userDto() {
		UserDTO dto = new UserDTO();
		dto.setUserId("Rudra12345");
		dto.setEmail("Rudra@gmail.com");
		dto.setMobile(8088928928L);
		System.out.println(dto);
		return dto;
	}
}