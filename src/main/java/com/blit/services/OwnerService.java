package com.blit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blit.models.Owner;

public interface OwnerService {
	
	Owner getOwner(Long id);
	
	Owner getOwner(String firstName);
	
	List<Owner> getOwners();
	
	void deleteOwner(Long id);
	
	Owner saveOwner(Owner owner);
	
	Owner updateOwner(Long id, Owner owner);

}
