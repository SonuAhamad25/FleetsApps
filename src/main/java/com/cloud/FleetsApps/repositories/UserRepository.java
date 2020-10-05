package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
	

}
