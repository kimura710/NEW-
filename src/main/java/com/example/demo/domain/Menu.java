package com.example.demo.domain;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Menu {
	@Id
	private int id;
	
	@NotBlank(message = "タイトルを入力してください")
	private String name;
	
	@Size(max = 10, message = "文字数オーバーです")
	private String course;
	
	@Size(max = 1000,message = "文字数オーバーです")
	private String recette;
	
	@Size(max = 1000,message = "文字数オーバーです")
	private String memo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecette() {
		return recette;
	}

	public void setRecette(String recette) {
		this.recette = recette;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
