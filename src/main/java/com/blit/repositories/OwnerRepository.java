package com.blit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

	
}
