package com.coder.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.coder.demo.component.AuthorizationExtractor;
import com.coder.demo.component.JwtTokenProvider;
import com.coder.demo.exception.InvalidAuthenticationException;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	private AuthorizationExtractor authExtractor;
	private JwtTokenProvider jwtTokenProvider;
	
	public AuthInterceptor(AuthorizationExtractor authExtractor, JwtTokenProvider jwtTokenProvider) {
		this.authExtractor = authExtractor;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	/// 'Authorization': 'Bearer ' + localStorage.getItem("jwt") header에 이렇게 넣어주기
	@Override
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception{

		String token = authExtractor.extract(request, "Bearer");
		System.out.println(">>> interceptor.preHandle 호출");
		if (StringUtils.isEmpty(token)) {
            return true;
        }
		
		if(!jwtTokenProvider.validateToken(token)) {  // 토큰의 유효성 검증
            throw new InvalidAuthenticationException("만료된 세션입니다.");
        };
        
        String id = jwtTokenProvider.getSubject(token);
        request.setAttribute("loginUserId", id);
        return true;
	}
}
