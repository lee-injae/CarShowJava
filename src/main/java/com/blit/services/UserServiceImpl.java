package com.blit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.models.User;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override 
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		Optional<User> userOpt = userRepository.findByUsername(username);	
		
		UserBuilder builder = null; 
		if (userOpt.isPresent()) {
			User currentUser = userOpt.get();
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole(), "Other role");
			
			return builder.build();
			
		} else {
			throw new UsernameNotFoundException("user not found");
		}
		
	}
	
	
}
