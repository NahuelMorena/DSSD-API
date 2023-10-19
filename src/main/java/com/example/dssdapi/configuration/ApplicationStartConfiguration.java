package com.example.dssdapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.example.dssdapi.model.User;
import com.example.dssdapi.model.UserRole;
import com.example.dssdapi.repositories.UserRepository;

public class ApplicationStartConfiguration implements ApplicationRunner {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		User user= User.builder().username("user").password("1234").role(UserRole.USER).build();
		userRepository.save(user);

	}

}
