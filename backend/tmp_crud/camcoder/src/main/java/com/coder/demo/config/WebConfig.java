package com.coder.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.coder.demo.component.PasswordEncoder;
import com.coder.demo.interceptor.AuthInterceptor;
import com.coder.demo.interceptor.ExecuteTimeInterceptor;
import com.coder.demo.resolver.LoginMemberMethodArgumentResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	private final ExecuteTimeInterceptor executeTimeInterceptor;
	private final AuthInterceptor authInterceptor;
    private final LoginMemberMethodArgumentResolver loginMemberArgumentResolver;
    private final PasswordEncoder passwordEncoder;
	
	public WebConfig(ExecuteTimeInterceptor executeTimeInterceptor, AuthInterceptor authInterceptor,
			LoginMemberMethodArgumentResolver loginMemberArgumentResolver, PasswordEncoder passwordEncoder) {
		this.executeTimeInterceptor = executeTimeInterceptor;
		this.authInterceptor = authInterceptor;
		this.loginMemberArgumentResolver = loginMemberArgumentResolver;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {	
		registry.addInterceptor(executeTimeInterceptor);
		registry.addInterceptor(authInterceptor).excludePathPatterns("/login").excludePathPatterns("/signup");//.addPathPatterns("/user").addPathPatterns("/users");
	}
	
	//@Override
    /*public void addArgumentResolvers(List argumentResolvers) {
        argumentResolvers.add(loginMemberArgumentResolver);
    }*/
}
