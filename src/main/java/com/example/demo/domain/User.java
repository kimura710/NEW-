package com.example.demo.domain;

import javax.persistence.Id;
import javax.validation.constraints.Size;

public class User {
	@Id
	private  Long id;
	@Size(min = 2,max = 20)
	private String userName;
	@Size(min = 2,max = 255)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
