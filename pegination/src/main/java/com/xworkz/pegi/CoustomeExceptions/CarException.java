package com.xworkz.pegi.CoustomeExceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarException extends Exception {

	public CarException(String msg) {
		log.info("Running in carExceptinon");
	}
}
