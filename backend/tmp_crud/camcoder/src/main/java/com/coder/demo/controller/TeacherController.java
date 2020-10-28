package com.coder.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.component.RegisterRequest;
import com.coder.demo.component.SignupRequest;
import com.coder.demo.service.TeacherService;
import com.coder.demo.vo.Teacher;
import com.coder.demo.vo.User;

@RestController
public class TeacherController {	
	@Autowired
	TeacherService tservice;

	@PostMapping(value = "/teachers")
	public String insert(@Valid @RequestBody RegisterRequest register, HttpServletRequest request) throws Exception{
		String id = (String)(request.getAttribute("loginUserId"));
		tservice.insert(register, id);		
		return "등록 완료";
	}
	
	@PutMapping(value = "/teachers")
	public String update(@Valid @RequestBody RegisterRequest register, HttpServletRequest request) throws Exception{
		String id = (String)(request.getAttribute("loginUserId"));
		tservice.update(register, id);	
		return "변경 완료"; //
	}
	
	@DeleteMapping(value = "/teachers")
	public String update(HttpServletRequest request) throws Exception{
		String id = (String)(request.getAttribute("loginUserId"));
		tservice.delete(id);	
		return "삭제 완료"; //
	}
	
	@GetMapping(value = "/teachers/{code}")
	public Teacher selectOne(@Valid @PathVariable long code) {
		return tservice.selectOneByCode(code);
	}

	@PostMapping(value = "/teachers/sorted")
	public Teacher sort(@Valid @PathVariable long code) {
		return tservice.selectOneByCode(code);
	}
	
	
}
