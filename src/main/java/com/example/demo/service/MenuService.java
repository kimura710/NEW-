package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Menu;
import com.example.demo.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;
	
	public List<Menu> search(){
		return menuRepository.selectAll();
	}
	public Menu search(int id) {
		return menuRepository.selectPK(id);
	}
	@Transactional
	public void save(Menu menu) {
		menuRepository.insert(menu);
	}
	@Transactional
	public void update(Menu menu) {
		menuRepository.update(menu);
	}
	@Transactional
	public void delete(int id) {
		menuRepository.delete(id);
	}
	

}
