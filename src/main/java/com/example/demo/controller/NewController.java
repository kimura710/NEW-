package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Menu;
import com.example.demo.service.MenuService;

@Controller
@RequestMapping("/menus")
public class NewController {
	@Autowired
	private MenuService service;
	
	@GetMapping("new")
	public String newMenu(@ModelAttribute("menu") Menu menu) {
		return "new";
	}
	@PostMapping
	public String create (@ModelAttribute("menu") @Validated Menu menu,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "new";
		}else {
			service.save(menu);
			return "redirect:/menus/index";
		}
	}

}
