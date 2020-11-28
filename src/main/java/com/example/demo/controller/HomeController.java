package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	
	@GetMapping("/home")
	public String getHome(Model model,@AuthenticationPrincipal User user) {
		log.info("HomeController Start");
		
		log.info(user.toString());
		
		log.info("HomeController END");
		
		return "home";
	}

}
