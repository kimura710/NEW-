package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Menu;

@Mapper
public interface MenuRepository {
	@Select("select * from menu")
	List<Menu> selectAll();
	
	@Select("select * from menu where id=#{id}")
	Menu selectPK(int id);
	
	@Insert("insert into menu values(#{id},#{name},#{course},#{recette},#{memo})")
    void insert(Menu menu);
	
	@Update("update menu set name=#{name},course=#{course},recette=replace(#{recette},'\n',''),memo=replace(#{memo},'\n','') where id=#{id}")
	void update(Menu menu);
	
	@Delete("delete from menu where id=#{id}")
	void delete(int id);
}
