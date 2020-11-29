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
		 repository.registerUser(user);
		
	}
}
