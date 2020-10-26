package com.coder.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coder.demo.vo.Message;

@Repository
public interface MessageDAO extends JpaRepository<Message, Long>{
	/*public List<Message> selectAll();
	public Message selectOne(Long code);
	public void insert(Message m);*/
	
	Message findByMessageCode(@Param("messageCode") long messageCode);
}
