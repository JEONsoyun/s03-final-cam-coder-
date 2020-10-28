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
@Table(name = "like_teachers")
@EntityScan(basePackages = {"com.coder.demo.vo"})
public class Like implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long likeCode;
	
	private Long userCode;
	private Long teacherCode;
	private Date likeDate;
	
	
	@PrePersist
	public void beforeCreate() {
		this.likeDate = new Date();
	}
	
	public Like(long userCode, long teacherCode) {
		this.userCode = userCode;
		this.teacherCode =teacherCode ;
	}
	
	@Override
	public String toString() {
		return "Like [likeCode=" + likeCode + ", userCode=" + userCode + ", teacherCode=" + teacherCode + ", likeDate="
				+ likeDate + "]";
	}
	public Like() {
	}

	public Long getLikeCode() {
		return likeCode;
	}

	public void setLikeCode(Long likeCode) {
		this.likeCode = likeCode;
	}

	public Long getUserCode() {
		return userCode;
	}

	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public Long getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(Long teacherCode) {
		this.teacherCode = teacherCode;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

}
