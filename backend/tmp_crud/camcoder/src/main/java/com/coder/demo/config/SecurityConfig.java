package com.coder.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/script/**", "image/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//https://effectivecode.tistory.com/1018 : 여기서 참고하였다 .왜 이렇게 되는 걸까?
		http.cors().and();
		http.csrf().disable();
	}
}
