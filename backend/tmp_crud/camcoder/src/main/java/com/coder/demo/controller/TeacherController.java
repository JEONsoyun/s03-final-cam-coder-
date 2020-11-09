package com.coder.demo.controller;

import java.util.List;
import java.util.Optional;

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
import com.coder.demo.service.TeacherService;
import com.coder.demo.vo.Teacher;

@RestController
public class TeacherController {	
	@Autowired
	TeacherService tservice;
	
	@GetMapping(value = "/teachers/all")
	public List<Teacher> selectAll() { // select
		return tservice.selectAll(); // List -> json(by jackson)
	}

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
		return "변경 완료";
	}
	
	@DeleteMapping(value = "/teachers")
	public String update(HttpServletRequest request) throws Exception{
		String id = (String)(request.getAttribute("loginUserId"));
		tservice.delete(id);	
		return "삭제 완료";
	}
	
	@GetMapping(value = "/teachers/me")
	public Teacher findMe(HttpServletRequest request) {
		String id = (String)(request.getAttribute("loginUserId"));
		return tservice.selectOneByMyCode(id);
	}
	
	@GetMapping(value = "/teachers/{code}")
	public Teacher selectOne(@Valid @PathVariable long code) {
		return tservice.selectOneByCode(code);
	}

	@PostMapping(value = "/teachers/sorted")
	public List<Teacher> sort(@Valid @RequestBody RegisterRequest register) {
		//아무 값이 없으면 0(수업량 순으로 정렬된다) (0 : 수업량(studentcnt), 1 : 좋아요(like))
		int type = Optional.ofNullable(register).map(RegisterRequest::getSorttype).orElse(0);
		if(type > 1) {
			type = 1;
		}
		
		return tservice.sortBy(type);
	}
	
	@PostMapping(value = "/teachers/search")
	public List<Teacher> search(@Valid @RequestBody RegisterRequest register) {
		//null이면 무슨 값으로 넣어주지 일단은 "-1" -> 전체다 보이게함
		String keyword = Optional.ofNullable(register).map(RegisterRequest::getKeywords).orElse("-1");
		
		if(keyword.equals("-1")) {
			return tservice.selectAll();
		}
		return tservice.contain(keyword);
	}
	
}
