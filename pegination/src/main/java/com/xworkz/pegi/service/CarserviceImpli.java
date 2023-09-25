package com.xworkz.pegi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xworkz.pegi.dto.Car;
import com.xworkz.pegi.entity.CarEntity;
import com.xworkz.pegi.repositery.CarRepositery;

@Service
public class CarserviceImpli implements CarService {

	@Autowired
	private CarRepositery carRepositery;

	public CarserviceImpli() {
		System.out.println("Running in carService ");
	}

	@Override
	public boolean onsave(Car car) {
		CarEntity carEntity = new CarEntity();
		BeanUtils.copyProperties(car, carEntity);
		this.carRepositery.save(carEntity);
		return true;
	}

	@Override
	public Page findAll(Pageable pageable) {
		System.out.println();
		return this.carRepositery.findAll(pageable);
	}

}
