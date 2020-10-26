package com.coder.demo.service;

import java.util.List;

import com.coder.demo.vo.Message;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;

public interface MessageService {
	public List<Message> selectAll();//유저가 참여한 대화중 제일 최신 정보만
	public Message selectOne(Long code);
	public void insert(Message m);
}
