package com.xworkz.pegi.controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class Handaling {
	public Handaling() {
		log.info("Running in controller advise");
	}
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Custom logic to handle the exception
        // You can log the error or perform any other necessary operations
        
        // Return a response entity with an error message and appropriate HTTP status
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        // Custom logic to handle the NotFoundException
        // You can log the error or perform any other necessary operations
        
        // Return a response entity with an error message and appropriate HTTP status
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
