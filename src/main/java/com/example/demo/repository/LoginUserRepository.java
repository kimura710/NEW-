package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginUserRepository {

	@Autowired
	private JdbcTemplate jdbc;
	
	private static final String SELECT_USER_SQL = "SELECT * "+" FROM m_user" + "WHERE user_id = ?";
}
