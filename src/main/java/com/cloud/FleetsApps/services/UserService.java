package com.cloud.FleetsApps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.User;
import com.cloud.FleetsApps.repositories.UsersRepository;
@Service
public class UserService {
@Autowired	
private UsersRepository userRepository;
@Autowired	
private BCryptPasswordEncoder encoder;

	public void save(User user) {
		//this is use for encoder start
		user.setPassword(encoder.encode(user.getPassword()));
		//this is use for encoder End
		userRepository.save(user);
		
	}

}
