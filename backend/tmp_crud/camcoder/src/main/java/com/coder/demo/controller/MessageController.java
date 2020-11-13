package com.coder.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.coder.demo.component.MessageRequest;
import com.coder.demo.service.MessageService;
import com.coder.demo.vo.Message;

@RestController
public class MessageController {
	@Autowired
	MessageService mservice;
	
	@PostMapping(value="/message")
	public String insert(@RequestBody MessageRequest m, HttpServletRequest request) throws Exception {
		mservice.insert(m, ((String)request.getAttribute("loginUserId")));
		return "메세지 입력 완료!";
	}
	
	@GetMapping(value="/message/{code}")
	public List<Message> selectOne(@PathVariable Long code, HttpServletRequest request) {
		return mservice.selectOne(code, ((String)request.getAttribute("loginUserId")));//code는 상대방 유저의 code를 의미!
	}
	
	@GetMapping(value="/message")
	public List<Message> selectAll(HttpServletRequest request) {
		return mservice.selectAll(((String)request.getAttribute("loginUserId")));
	}
	
}
