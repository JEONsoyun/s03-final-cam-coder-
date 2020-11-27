package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coder.demo.vo.Message;

@Repository
public interface MessageDAO extends JpaRepository<Message, Long>{


	@Query("Select m from Message m where (m.sender.userCode= ?1 and m.receiver.userCode = ?2) or (m.receiver.userCode = ?1 and m.sender.userCode = ?2) order by m.sendDate asc")
	List<Message> findBySenderAndReceiver(Long sender, Long receiver);
	
	@Query("Select m from Message m where m.sender.userCode = ?1 or m.receiver.userCode = ?1 order by m.sendDate desc")
	List<Message> findBySender(Long sender);
	List<Message> findAll();

}
