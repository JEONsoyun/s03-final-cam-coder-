package com.coder.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coder.demo.component.JwtTokenProvider;
import com.coder.demo.component.LoginRequest;
import com.coder.demo.component.SignupRequest;
import com.coder.demo.dao.UserDAO;
import com.coder.demo.exception.NotExistIdException;
import com.coder.demo.exception.WrongPasswordException;
import com.coder.demo.vo.User;

//3.Service 객체
@Service
public class UserServiceImpl implements UserService {
	//dao auto-inject

	@Autowired
	UserDAO userdao;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> selectAll() {
		return userdao.findAll();
	}

	@Override
	public User selectOneByCode(long userCode) {
		return userdao.findByUserCode(userCode);
	}

	@Override
	public User selectOneByID(String id) {
		return userdao.findByUserId(id);
	}
	
	@Override
	public void insert(SignupRequest request) throws Exception{
		String encPw = "";
		
		Optional.of(request)
		.map(SignupRequest::getPw).orElseThrow(NotExistIdException::new);

		encPw = passwordEncoder.encode(request.getPw());
		try {
			//Optional.of(request)
			//.map(SignupRequest::getId).map(SignupRequest::getName).map(SignupRequest::getProfile)
			//.ifPresent(pw -> now.setUserPw(pw));
			
			userdao.save(new User(request.getId(), encPw, request.getName(), request.getProfile()));
		}catch(DataAccessException ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause().getMessage());
		}
	}

	@Override
	public String createToken(LoginRequest loginRequest) throws Exception{
		User user = Optional.ofNullable(userdao.findByUserId(loginRequest.getId())).orElseThrow(NotExistIdException::new);
		
		if(!(passwordEncoder.matches(loginRequest.getPw(), user.getUserPw()))) {
			throw new WrongPasswordException();
		}
		
		System.out.println("비밀번호 일치");
		return JwtTokenProvider.createToken(loginRequest.getId());
	}

	@Override
	public void update(String id, @Valid SignupRequest u) {
		User now = userdao.findByUserId(id);
		
		Optional.of(u)
		.map(SignupRequest::getPw).ifPresent(pw -> now.setUserPw(passwordEncoder.encode(pw)));

		Optional.of(u)
		.map(SignupRequest::getName).ifPresent(name -> now.setUserName(name));
		
		Optional.of(u)
		.map(SignupRequest::getProfile).ifPresent(profile -> now.setUserProfile(profile));
		
		userdao.save(now);
	}
}
