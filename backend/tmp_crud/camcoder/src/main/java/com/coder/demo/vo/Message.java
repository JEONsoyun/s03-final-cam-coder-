package com.coder.demo.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "messages")
@EntityScan(basePackages = {"com.coder.demo.vo"})
public class Message implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long messageCode;
	
	private Date sendDate;
	private String content;
	@Column(name="mfrom")
	private Long from;
	
	@Column(name="mto")
	private Long to;
	private boolean isRead;
	
	@PrePersist
	public void beforeCreate() {
		this.sendDate = new Date();
	}
	
	public Message(String content, long from, long to) {
		this.content = content;
		this.from = from;
		this.to = to;
		this.isRead = false;
	}
	@Override
	public String toString() {
		return "Message [messageCode=" + messageCode + ", sendDate=" + sendDate + ", content=" + content + ", from="
				+ from + ", to=" + to + ", isRead=" + isRead + "]";
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
	public Long getFrom() {
		return from;
	}
	public void setFrom(Long from) {
		this.from = from;
	}
	public Long getTo() {
		return to;
	}
	public void setTo(Long to) {
		this.to = to;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
}
