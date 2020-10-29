package com.coder.demo.controller;

import java.util.List;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.component.SignupRequest;
import com.coder.demo.service.UserService;
import com.coder.demo.vo.User;

@RestController
public class UserController {

	private final AtomicLong cnt = new AtomicLong();

	@Autowired
	UserService userservice;

<<<<<<< HEAD

	@PostMapping(value = "/signup")
=======
	@PostMapping(value = "/users/signup")
>>>>>>> c985d3dfd7578bcf5dbfae9b889cf66425ec62af
	public Object insert(@Valid @RequestBody SignupRequest request) throws Exception{
		userservice.insert(request);
		System.out.println(request.getId());
		return "회원 가입 완료"; //
	}

	@GetMapping(value = "/users/all")
	public List<User> selectAll() { // select
		return userservice.selectAll(); // List -> json(by jackson)
	}

<<<<<<< HEAD

	@GetMapping(value = "/user") // select
=======
	@GetMapping(value = "/users") // select
>>>>>>> c985d3dfd7578bcf5dbfae9b889cf66425ec62af
	public User selectOne(HttpServletRequest request) {
		return userservice.selectOneByID((String)(request.getAttribute("loginUserId"))); // List -> json(by jackson)
	}

	@GetMapping(value = "/users/{code}") // select
	public User selectOne(HttpServletRequest request, @PathVariable long code) {
		return userservice.selectOneByCode(code); // List -> json(by jackson)
	}

	
	@PutMapping(value = "/users") // update
	public String update(@Valid @RequestBody SignupRequest u, HttpServletRequest request) throws Exception { // json-> java object
		String id = (String)(request.getAttribute("loginUserId"));
		
		userservice.update(id, u);
		return "update success";
	}

	
	
}
