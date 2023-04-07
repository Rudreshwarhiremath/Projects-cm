package com.xworkz.pro.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
	@GetMapping(value = "/reemail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String reEmail(@PathVariable String email) {
		Long dbEmail = this.userService.findByEmail(email);
		System.err.println(dbEmail);

		if (dbEmail == 0) {
			System.err.println("Running in equals condition");
			return "Please enter Existing email";
		} else {
			return "  ";
		}
	}
	

}
