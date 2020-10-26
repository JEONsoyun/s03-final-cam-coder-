package com.coder.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		long startTime = System.currentTimeMillis();
		request.setAttribute("starttime", startTime);
		
		String reqUri = request.getRequestURI();
		System.out.println("reqUri" + reqUri);
		System.out.println("starttime : " + request.getAttribute("starttime"));
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		long startTime = (Long)request.getAttribute("starttime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		
		request.setAttribute("executeTime", executeTime);
		System.out.println("["+handler+"] execute Time : " + executeTime + "ms");
	}
}
