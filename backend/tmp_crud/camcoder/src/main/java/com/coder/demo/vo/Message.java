package com.coder.demo.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "messages")
@EntityScan(basePackages = {"com.coder.demo.vo"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Message implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long messageCode;
	
	private Date sendDate;
	private String content;
	
	//private Long sender;	
	@ManyToOne
	@JoinColumn(name="sender")
	private User sender;
	
	//private Long receiver;
	@ManyToOne
	@JoinColumn(name="receiver")
	private User receiver;
	
	private Byte isRead;
	
	@PrePersist
	public void beforeCreate() {
		this.sendDate = new Date();
	}
	
	/*public Message(String content, Long sender, Long receiver) {
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
		this.isRead = 0;
	}*/
	
	public Message(String content, User sender, User receiver) {
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
		this.isRead = 0;
	}

	public Message() {
	}
	
	public Long getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(Long messageCode) {
		this.messageCode = messageCode;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	/*public Long getSender() {
		return sender;
	}


	public void setSender(Long sender) {
		this.sender = sender;
	}


	public Long getReceiver() {
		return receiver;
	}


	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}*/
	
	public void setIsRead(Byte isRead) {
		this.isRead = isRead;
	}

	public Byte getIsRead() {
		return isRead;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

}
