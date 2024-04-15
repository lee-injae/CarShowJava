package com.blit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	//fetch car by brand
	List<Car> findCarByBrand(String brand);
	//fetch car by color
	List<Car> findCarByColor(String color); 
	//fetch car by year
	List<Car> findCarByYear(int year);
	//fetch car by color and model
	List<Car> findCarByBrandAndModel(String brand, String model);
	//fetch car by year and sort by year
	List<Car> findCarByBrandOrderByYearAsc(String brand);
	
	
}
