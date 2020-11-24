package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MenuService;

@Controller
@RequestMapping("/menus")
public class SecurityController {
	@Autowired
	private MenuService service;
	

	
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("menus",service.search());
		return "index";
	}
	

}
