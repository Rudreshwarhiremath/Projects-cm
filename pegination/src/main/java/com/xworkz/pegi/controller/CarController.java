package com.xworkz.pegi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.pegi.dto.Car;
import com.xworkz.pegi.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// ControllerAdvice
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
	@Autowired
	private CarService carService;

	public CarController() {
		System.out.println("Running in controller");
	}

	@PostMapping(value = "/saveData")
	public Car onSave(@RequestBody Car car) {
		log.info("Running in Car method");
		this.carService.onsave(car);
		return car;
	}

	@GetMapping("/List")
	public Page findAll(Pageable pageable) {
		return this.carService.findAll(pageable);
	}

}
