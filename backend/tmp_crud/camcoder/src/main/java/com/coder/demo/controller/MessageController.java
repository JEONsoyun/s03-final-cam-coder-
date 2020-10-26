package com.coder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.service.MessageService;
import com.coder.demo.vo.Message;

@RestController
public class MessageController {
	@Autowired
	MessageService mservice;
	
	@PostMapping(value="/message")
	public String insert(@RequestBody Message m) {
		mservice.insert(m);
		return "insert";
	}
	
	@GetMapping(value="/message/{code}")
	public Message selectOne(@PathVariable Long code) {
		return mservice.selectOne(code);
	}
	
	@GetMapping(value="/message")
	public List<Message> selectAll() {
		return mservice.selectAll();
	}
}
