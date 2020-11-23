package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private final UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// パスワードの暗号化用
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		//認証リクエストの設定
		   .authorizeRequests()
		   .antMatchers("/login","/register").permitAll()
		  // .antMatchers("/admin/**").hasRole(Role.ADMIN.name())
		   .anyRequest().authenticated()
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
		auth.userDetailsService(userDetailsService)
		    .passwordEncoder(passwordEncoder());
	}

}
