package com.blit.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	
	
	
	

}
