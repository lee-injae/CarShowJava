package com.blit.services;

import java.util.List;

import com.blit.models.Car;

public interface CarService {
	
	List<Car> getCars();
	
	Car getCarById(Long id);

}
