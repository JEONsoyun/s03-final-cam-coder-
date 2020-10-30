package com.coder.demo.service;

import java.util.HashSet;
import java.util.LinkedList;
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
		
		List<Message> list = messagedao.findBySender(scode);
		
		List<Message> result = new LinkedList<Message>();
		HashSet check = new HashSet<Long>();
		
		for(Message now : list) {
			long num = now.getReceiver();
			if(num == scode) {
				num = now.getSender();
			}
			
			if(!check.isEmpty()) {
				if(!check.contains(num)) {
					check.add(num);
					result.add(now);
				}
			}else {
				check.add(num);
				result.add(now);
			}
		}
		
		return result;
	}

	@Override
	public List<Message> selectOne(Long code, String sender) {
		Long scode = userdao.findByUserId(sender).getUserCode();
		
		List<Message> list = messagedao.findBySenderAndReceiver(scode, code);		
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
