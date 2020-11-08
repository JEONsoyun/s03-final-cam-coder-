package com.coder.demo.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {
	@Before("execution(* *..UserService.*(..))")
	public void beforeAdvice() {
		System.out.println("before aop!");
	}
}
