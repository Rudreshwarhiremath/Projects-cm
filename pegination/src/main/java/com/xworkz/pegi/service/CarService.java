package com.xworkz.pegi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xworkz.pegi.dto.Car;

public interface CarService {
	boolean onsave(Car car);

	Page findAll(Pageable pageable);

}
