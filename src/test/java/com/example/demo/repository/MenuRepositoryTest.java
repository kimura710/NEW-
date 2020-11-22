package com.example.demo.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Menu;

@RunWith(SpringRunner.class)
@MybatisTest
@TestPropertySource(locations = "classpath:test.properties")
public class MenuRepositoryTest {
	@Autowired
	private MenuRepository sut;
	
	@Test
	public void 検索＿全件して結果をリストで所得出来る() throws Exception{
		List<Menu> actual = sut.selectAll();
		assertThat(actual.size()).isEqualTo(3);
	}

}
