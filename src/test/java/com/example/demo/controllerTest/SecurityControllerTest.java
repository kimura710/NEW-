package com.example.demo.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.SecurityController;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SecurityControllerTest {

	// Tomcatサーバへデプロイする事なくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
	
	private MockMvc mockMvc;
	
	@Autowired
	SecurityController target;
	
	@Before
	public void Setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(target).build();
	}
	@Test
	void isStatusTest() throws Exception{
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
}
