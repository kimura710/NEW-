package com.example.demo.domain;

import javax.persistence.Id;
import javax.validation.constraints.Size;

public class SiteUser {
	@Id
	private  Long id;
	@Size(min = 2,max = 20)
	private String username;
	@Size(min = 2,max = 255)
	private String password;
	
	private String role;
	private boolean admin;
	private boolean active = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
