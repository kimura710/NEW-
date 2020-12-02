package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.AppUserDetails;
import com.example.demo.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String signup() {
		return "register";
	}
	@PostMapping("/register")
	public String register(@RequestParam("userId")String userId,@RequestParam("password")String password) {
		AppUserDetails user = new AppUserDetails();
		user.setUserId(userId);
		user.setAppUserName(userId);
		user.setPassword(passwordEncoder.encode(password));
		
		service.registerUser(user);
		
		return "login";
	}

}
