package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String show(Authentication loginUser,Model model) {
		model.addAttribute("username",loginUser.getName());
		model.addAttribute("role",loginUser.getAuthorities());
		return "/home";
	}

}
