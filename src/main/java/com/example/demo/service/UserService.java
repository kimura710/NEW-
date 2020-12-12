package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.AppUserDetails;
import com.example.demo.repository.LoginUserRepository;

@Service
public class UserService {

	@Autowired
	private LoginUserRepository repository;
	
	@Transactional
	public void registerUser(AppUserDetails user) {
		int result = 0;
		result += repository.registerUser(user);
		
		result += repository.registerUserRole(user);
		
		if(result != 2) {
			throw new RuntimeException();
		}
	}
}
