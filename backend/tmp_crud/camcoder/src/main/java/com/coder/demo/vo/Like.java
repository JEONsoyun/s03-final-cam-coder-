package com.coder.demo.vo;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "like_teachers")
@EntityScan(basePackages = {"com.coder.demo.vo"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Like{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long likeCode;
	
	private Long userCode;
	private Date likeDate;
	
	@ManyToOne
	@JoinColumn(name = "teacher_code",referencedColumnName = "teacher_code")
	private Teacher likeTeacher;
	
	public Like(Long userCode, Teacher teacher) {
		this.userCode = userCode;
		this.likeTeacher = teacher;
	}

	@PrePersist
	public void beforeCreate() {
		this.likeDate = new Date();
	}
	
	public Like() {
	}

	public Long getLikeCode() {
		return likeCode;
	}

	public void setLikeCode(Long likeCode) {
		this.likeCode = likeCode;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public Long getUserCode() {
		return userCode;
	}

	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public Teacher getTeacher() {
		return likeTeacher;
	}

	public void setTeacher(Teacher teacher) {
		this.likeTeacher = teacher;
	}

}
