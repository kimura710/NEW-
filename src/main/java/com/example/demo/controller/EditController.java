package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Menu;
import com.example.demo.service.MenuService;

@Controller
@RequestMapping("/menus")
public class EditController {
	@Autowired
	private MenuService service;
	
	@GetMapping("{id}/edit")
	public String edit(@PathVariable int id,Model model) {
		model.addAttribute("menu",service.search(id));
		return "edit";
	}
	@PostMapping("{id}")
	public String update(@PathVariable int id,@ModelAttribute("menu") @Validated Menu menu,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("menu",menu);
			return "edit";
		}else {
			menu.setId(id);
			service.update(menu);
			return "redirect:/menus/index";
		}
	
	}
	

}
