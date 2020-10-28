package com.coder.demo.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="users")
@EntityScan(basePackages = {"com.coder.demo.vo"})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userCode;
	
	private String userId;
	private String userPw;
	private String userName;
	private String userProfile;
	
	private Date joinDate;
	
	@PrePersist
	public void beforeCreate() {
		this.joinDate = new Date();
	}
	
	public User(String userId, String userPw, String userName, String userProfile) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userProfile = userProfile;
	}

	public User() {
	}

	public Long getUserCode() {
		return userCode;
	}

	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public boolean checkPassword(String pw) {
		return this.userPw.equals(pw);
	}

}
