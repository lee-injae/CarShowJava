package com.blit;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blit.models.Car;
import com.blit.repositories.CarRepository;

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {
	
	@Autowired
	private CarRepository carRepository; 
	
	private static final Logger logger =  LoggerFactory.getLogger(CarShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);
		logger.info("application started");
	}
	
	@Override 
	public void run(String... args) throws Exception {
		List<Car> cars = Arrays.asList(
				  new Car("Ford","Mustang","Red","ADF_1121",2021,49000),
	              new Car("Nissan","Leaf","Gray","EBF_1221",2020,32500),
	              new Car("Toyota","Camry","Silver","CDF_3123",2021,32000),
	              new Car("Toyota","Corolla","White","DDF_3421",2023,40000)
				);
		carRepository.saveAll(cars);
		// Fetch all cars and log to console
		carRepository.findAll().forEach(car -> logger.info(car.getBrand() + " " + car.getModel()));
					
	}

}
