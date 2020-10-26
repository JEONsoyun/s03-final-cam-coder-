package com.coder.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

	@RequestMapping("/home")
	public String home() {
		return "hello world"+cnt.incrementAndGet();
	}

	@PostMapping(value = "/user") // signup
	public Object insert(@Valid @RequestBody SignupRequest request) throws Exception{
		userservice.insert(request);
		return "success insert ";
	}

	@GetMapping(value = "/user")
	public List<User> selectAll() { // select
		return userservice.selectAll(); // List -> json(by jackson)
	}

	@GetMapping(value = "/user/{uid}") // select
	public User selectOne(@PathVariable String uid) {
		return userservice.selectOneByID(uid); // List -> json(by jackson)
	}

	
	@PutMapping(value = "/user") // update
	public String update(@RequestBody User u) { // json-> java object
		userservice.update(u);
		return "update success";
	}

	
	
}
