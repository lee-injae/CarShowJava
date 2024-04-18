package com.blit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

	Optional<Owner> findOwnerById(Long id);
	
	List<Owner> findOwnerByFirstName(String firstName);
	
	
	
}
