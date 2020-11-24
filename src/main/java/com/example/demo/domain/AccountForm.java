package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@SuppressWarnings("serial")
@Entity
@Data
public class AccountForm implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false,updatable = false)
	private Date created_at;
	@Column(nullable = false)
	private Date updated_at;

}
