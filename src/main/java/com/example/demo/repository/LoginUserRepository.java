package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.AppUserDetails;

@Mapper
public interface LoginUserRepository {

	@Insert("insert into m_user values(#{user_id},#{password},'2099-12-31 23:59:59',0,true,'tenant','システム管理者','system@xxx.co.jp',true,'2099-12-31 23:59:59')")
	public void registerUser(AppUserDetails user);
	
	@Insert("insert into t_user_role(user_id,role_id) values(#{user_id},'admin')")
	public void registerUserRole(AppUserDetails user);
}
