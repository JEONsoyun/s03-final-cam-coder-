package com.coder.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coder.demo.vo.Message;

@Service
public class MessageServiceImpl implements MessageService {
	@Override
	public List<Message> selectAll() {
		return new ArrayList<Message>();
	}

	@Override
	public Message selectOne(Long code) {
		return null;
	}

	@Override
	public void insert(Message m) {
		System.out.println("input");
	}

}
