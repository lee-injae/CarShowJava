package com.blit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.models.Car;
import com.blit.repositories.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<Car> getCars() {
		return (List<Car>) carRepository.findAll(); //find all return iteral, so we need to cast to List type
	}
	
	@Override
	public Car getCarById(Long id) {
		Optional<Car> car = carRepository.findById(id);
		if(car.isPresent() ) {
			return car.get();
		} else {
			throw new ResourceNotFoundException("Oops, car with " + id + " does not exist in our database");
		}
		
	}
}
