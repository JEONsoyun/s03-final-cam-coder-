package com.coder.demo.service;

import java.util.List;

import com.coder.demo.component.MessageRequest;
import com.coder.demo.vo.Message;

public interface MessageService {
	public List<Message> selectAll(String sender);//유저가 참여한 대화중 제일 최신 정보만
	public List<Message> selectOne(Long code, String sender);
	public void insert(MessageRequest m, String sender) throws Exception;
}
