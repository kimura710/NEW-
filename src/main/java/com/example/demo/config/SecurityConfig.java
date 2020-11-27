package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;




@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// パスワードの暗号化用
		return new BCryptPasswordEncoder();
	}
	/*
	 * @Override
	 * public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/js/**","/css/**","/resources/**");
	    }
	 */
	 @Autowired
	 private DataSource datasource;
	 
	 private static final String USER_SQL = "SELECT"
			 +"user_id,"
			 +"password,"
			 +"enabled"
			 +"from"
			 +" m_user"
			 +"where"
			 +"user_id=?";
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		//認証リクエストの設定
		   .authorizeRequests()
		   .antMatchers("/login").permitAll()
		   .anyRequest()
		   .authenticated()
		   .and()
		.formLogin()
		   .loginPage("/login")
		   .defaultSuccessUrl("/")
		   .and()
		.logout()
		   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		  
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication()
		    .withUser("user")
		    .password(passwordEncoder().encode("password"))
		    // 権限を設定
		    .authorities("ROLE_USER");
	}
	
	
}