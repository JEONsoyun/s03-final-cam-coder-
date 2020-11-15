package com.coder.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import com.coder.demo.component.LoginRequest;
import com.coder.demo.component.SignupRequest;
import com.coder.demo.vo.User;

//2.CLIENT(Controller)를 위한 인터페이스
public interface UserService {
	public List<User> selectAll();
	public User selectOneByCode(long userCode);
	public String insert(SignupRequest request) throws Exception;
	public String createToken(LoginRequest loginRequest) throws Exception;
	public User selectOneByID(String id);
	public void update(String id, @Valid SignupRequest u);
}
