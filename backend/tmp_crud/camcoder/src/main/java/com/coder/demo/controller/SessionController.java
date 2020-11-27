package com.coder.demo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.component.LoginRequest;
import com.coder.demo.component.TokenResponse;
import com.coder.demo.service.UserService;

@RestController
public class SessionController {
	
	private final UserService userService;
	
	public SessionController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(value = "/users/login")
	public Object login(
			@Valid @RequestBody LoginRequest loginRequest) throws Exception{
		String token = userService.createToken(loginRequest);
		
		//token은  client의 locatStorage에 저장해두기
		return ResponseEntity.ok().body(new TokenResponse(token, "bearer"));
	}
}
