package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MenuService;

@Controller
@RequestMapping("/menus")
public class DeleteController {
	
	@Autowired
	private MenuService service;
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable int id,Model model) {
		service.delete(id);
		return "redirect:/menus/index";
	}

}
