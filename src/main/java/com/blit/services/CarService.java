package com.blit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blit.models.Car;

public interface CarService {
	
	List<Car> getCars();
	
	Car getCarById(Long id);

	Car saveCar(Car car);
	
	Car updateCar(Long id, Car car);
	
	void deleteCar(Long id);
	
}
