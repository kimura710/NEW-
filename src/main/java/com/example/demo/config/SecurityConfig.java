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
	
	  @Override
	  public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/js/**","/css/**","/resources/**");
	    }
	 
	 // データソース
	 @Autowired
	 private DataSource dataSource;
	 
	 // ユーザIDとパスワードを取得するSQL文
	 private static final String USER_SQL = "SELECT"
			 +" user_id,"
			 +" password,"
			 +" enabled"
			 +" from"
			 +" m_user"
			 +" where"
			 +" user_id=?";
	 
	 private static final String ROLE_SQL = "SELECT"
			 + " m_user.user_id,"
			 + " role.role_name"
			 + " FROM"
			 + " m_user INNER JOIN t_user_role AS user_role"
			 + " ON"
			 + " m_user.user_id = user_role.user_id"
			 + " INNER JOIN m_role AS role"
			 + " ON"
			 + " user_role.role_id = role.role_id"
			 + " WHERE"
			 + " m_user.user_id=?";
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		//認証リクエストの設定
		   .authorizeRequests()
		   .antMatchers("/login","/register").permitAll()
		   .anyRequest()
		   .authenticated()
		   .and()
		.formLogin()
		   .loginProcessingUrl("/login")
		   .loginPage("/login")
		   .failureUrl("/login?error")
		   .usernameParameter("userId")
		   .passwordParameter("password")
		   .defaultSuccessUrl("/home",true)
		   .and()
		.logout()
		   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		  
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.jdbcAuthentication()
		    .dataSource(dataSource)
		    .usersByUsernameQuery(USER_SQL)
		    .authoritiesByUsernameQuery(ROLE_SQL)
		    .passwordEncoder(passwordEncoder());
	}
	
	
}