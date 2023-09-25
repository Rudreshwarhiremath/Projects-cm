package com.xworkz.pegi.repositery;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.xworkz.pegi.entity.CarEntity;

public interface CarRepositery extends PagingAndSortingRepository<CarEntity, Long> {

}
