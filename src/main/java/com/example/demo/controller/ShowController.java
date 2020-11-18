package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MenuService;

@Controller
@RequestMapping("/menus")
public class ShowController {
	@Autowired
	private MenuService service;

	@GetMapping("{id}")
	public String show(@PathVariable int id,Model model) {
		model.addAttribute("menu",service.search(id));
		return "show";
	}
}
