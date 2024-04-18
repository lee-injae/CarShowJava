package com.blit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.models.Car;

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
	
	@Override 
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Car updateCar(Long id, Car car) {
		Optional<Car> optionalCar = carRepository.findById(id);
		if (optionalCar.isPresent()) {
			
			optionalCar.get().setBrand(car.getBrand());
			optionalCar.get().setModel(car.getModel());
			optionalCar.get().setColor(car.getColor());
			optionalCar.get().setPrice(car.getPrice());
			optionalCar.get().setYear(car.getYear());
			optionalCar.get().setOwner(car.getOwner());
			
			carRepository.save(optionalCar.get());
			
			return optionalCar.get();
		} else {
			throw new ResourceNotFoundException("Car with " + id + " does not exist");
		}
	}
	
	@Override
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}
	
//	@Override
//	public Car updateCar(Long id, Car car) {
//		Optional<Car> optionalCar = carRepository.findById(id);
//		if (optionalCar.isPresent()) {
//			
//		}
//	}
}
