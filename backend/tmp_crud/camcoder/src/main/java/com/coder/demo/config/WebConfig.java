package com.coder.demo.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.coder.demo.interceptor.AuthInterceptor;
import com.coder.demo.interceptor.ExecuteTimeInterceptor;
import com.coder.demo.resolver.LoginMemberMethodArgumentResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	private final ExecuteTimeInterceptor executeTimeInterceptor;
	private final AuthInterceptor authInterceptor;
    private final LoginMemberMethodArgumentResolver loginMemberArgumentResolver;
    
    
	public WebConfig(ExecuteTimeInterceptor executeTimeInterceptor, AuthInterceptor authInterceptor,
			LoginMemberMethodArgumentResolver loginMemberArgumentResolver) {
		this.executeTimeInterceptor = executeTimeInterceptor;
		this.authInterceptor = authInterceptor;
		this.loginMemberArgumentResolver = loginMemberArgumentResolver;
	}


	/*@Bean
	public ExecuteTimeInterceptor executeTimeInterceptor() {
		return new ExecuteTimeInterceptor();
	}*/
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(executeTimeInterceptor);
		registry.addInterceptor(authInterceptor).addPathPatterns("/user");
	}
	
	@Override
    public void addArgumentResolvers(List argumentResolvers) {
        argumentResolvers.add(loginMemberArgumentResolver);
    }
}
