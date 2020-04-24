package com.vega.springit.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;

@Service
public class UserService {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User register(User user) {
		
		return user;
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	
}
