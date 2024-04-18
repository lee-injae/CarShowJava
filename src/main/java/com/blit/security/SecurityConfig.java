package com.blit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.blit.services.UserServiceImpl;

//Configure my security filter bean
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//SecurityChain allows for chaining multiple methods together for configuration
	//represents the pre-configured security configuration/context
	
	@Autowired
	private UserServiceImpl userService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.httpBasic(Customizer.withDefaults()) //Basic config with web defaults
				.authorizeHttpRequests(//Authenticate all requests
						c -> c.anyRequest().authenticated())
				.build();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(bCryptPasswordEncoder()
//						.encode("password"))
//				.roles("ADMIN")
//				.build();
//		
//		UserDetails user = User.builder()
//				.username("user")
//				.password(bCryptPasswordEncoder()
//						.encode("password"))
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	
	
}
