package com.coder.demo.service;

import java.util.List;
import java.util.Optional;

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
	public User selectOne(long userCode) {
		return userdao.findByUserCode(userCode);
	}

	@Override
	public User selectOneByID(String id) {
		return userdao.findByUserId(id);
	}
	
	@Override
	public void insert(SignupRequest request) throws Exception{
		
		String encPw = passwordEncoder.encode(request.getPw());
		try {
			userdao.save(new User(request.getId(), encPw, request.getName(), request.getProfile()));
			//userdao.save(new User(request.getId(), request.getPw(), request.getName(), request.getProfile()));
		}catch(DataAccessException ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause().getMessage());
		}
	}

	@Override
	public void update(User u) {
		System.out.println("user update");
	}

	@Override
	public String createToken(LoginRequest loginRequest) throws Exception{
		Optional<User> user = Optional.of(Optional.of(userdao.findByUserId(loginRequest.getId())).orElseThrow(NotExistIdException::new));
		
		//if(!user.get().checkPassword(loginRequest.getPw())) {
		if(!(passwordEncoder.matches(loginRequest.getPw(), user.get().getUserPw()))) {
			throw new WrongPasswordException();
		}
		
		System.out.println("비밀번호 일치");
		return JwtTokenProvider.createToken(loginRequest.getId());
	}

}
