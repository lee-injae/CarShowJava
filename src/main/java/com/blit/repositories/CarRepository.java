package com.blit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
