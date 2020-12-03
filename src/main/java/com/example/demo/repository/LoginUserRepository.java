package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.AppUserDetails;

@Mapper
public interface LoginUserRepository {

	@Insert("insert into m_user (user_id,password) values (#{user_id},#{password})")
	int registerUser(AppUserDetails user);
	
	@Insert("insert into t_user_role (user_id) values (#{user_id})")
	int registerUserRole(AppUserDetails user);
}
