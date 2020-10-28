package com.coder.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.demo.component.MessageRequest;
import com.coder.demo.dao.MessageDAO;
import com.coder.demo.dao.UserDAO;
import com.coder.demo.exception.NotExistIdException;
import com.coder.demo.vo.Message;
import com.coder.demo.vo.User;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageDAO messagedao;
	
	@Autowired
	UserDAO userdao;
	
	@Override
	public List<Message> selectAll(String sender) {
		Long scode = userdao.findByUserId(sender).getUserCode();
		return messagedao.findBySender(scode);
	}

	@Override
	public List<Message> selectOne(Long code, String sender) {
		Long scode = userdao.findByUserId(sender).getUserCode();
		
		List<Message> list = messagedao.findBySenderAndReceiver(scode, code);
		list.addAll(messagedao.findBySenderAndReceiver(code, scode));
		
		list.sort(new Comparator<Message>() {
			@Override
			public int compare(Message o1, Message o2) {
				return o2.getSendDate().compareTo(o1.getSendDate());
			} 
		});
		
		return list;
	}

	@Override
	public void insert(MessageRequest m, String sender) throws Exception{
		//content가 비어있을 수도 있나?
		
		//sender, receiver code값 찾기
		User receiver = Optional.ofNullable(userdao.findByUserId(m.getReceiver())).orElseThrow(NotExistIdException::new);
		Long scode = userdao.findByUserId(sender).getUserCode();
		Long rcode = receiver.getUserCode();
		
		messagedao.save(new Message(m.getContent(), scode, rcode));
	}

}
