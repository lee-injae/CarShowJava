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
import com.blit.models.Owner;
import com.blit.models.User;
import com.blit.services.CarRepository;
import com.blit.services.OwnerRepository;
import com.blit.services.UserRepository;

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {
	
	@Autowired
	private CarRepository carRepository; 
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger logger =  LoggerFactory.getLogger(CarShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);
		logger.info("application started");
		
	}
	
	@Override 
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner("John", "Doe");
		Owner owner2 = new Owner("Joe", "Biden");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		
		List<Car> cars = Arrays.asList(
				  new Car("Ford","Mustang","Red","ADF_1121",2021,49000, owner1),
	              new Car("Nissan","Leaf","Gray","EBF_1221",2020,32500, owner2),
	              new Car("Toyota","Camry","Silver","CDF_3123",2021,32000, owner1),
	              new Car("Toyota","Corolla","White","DDF_3421",2023,40000, owner2)
				);
		
		carRepository.saveAll(cars);
		// Fetch all cars and log to console
		carRepository.findAll().forEach(car -> logger.info(car.getBrand() + " " + car.getModel()));
					
		Car newCar = new Car("Kia", "Sorento", "purple", "55-13", 1993, 70000.23, owner1);
		carRepository.save(newCar);
		
		List<Car> camry = carRepository.findCarByYear(2020);
		System.out.println("CAMRY!!!" + camry.get(0).getModel());
		carRepository.deleteAll(camry);
		
		userRepository.save(new User (
				"user",
				//bCrypt encoded password: userPass
				"$2y$10$dc3e3saiBRuwAmihOB0cWe8cI./MVgKIrdq9uCukCnRXYoNgYR1e6",
				"USER"));
		
		userRepository.save(new User (
				"admin",
				//password: adminPass
				"$2y$10$VKlPOmlBxacyOtoGuASJuu6F0E4Gf/VfiWsVZSHlr3xHzjn9DQ68W",
				"ADMIN"));
		
	}

}
