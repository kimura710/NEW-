package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.SiteUser;
import com.example.demo.repository.SiteUserRepository;
import com.example.demo.service.MenuService;
import com.example.demo.util.Role;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class SecurityController {
	@Autowired
	private MenuService service;
	
	private final SiteUserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("menus",service.search());
		return "index";
	}
	@GetMapping("/register")
	public String register(@ModelAttribute("user") SiteUser user) {
		return "register";
	}
	@PostMapping("/register")
	public String process(@Validated @ModelAttribute("user") SiteUser user,BindingResult result) {
		if(result.hasErrors()) {
			return "register";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(user.isAdmin()) {
			user.setRole(Role.ADMIN.name());
		}else {
			user.setRole(Role.USER.name());
		}
		userRepository.save(user);
		
		return "redirect:/login?register";
	}
	
	

}
