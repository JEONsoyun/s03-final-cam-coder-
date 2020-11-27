package com.coder.demo.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
@EntityScan(basePackages = {"com.coder.demo.vo"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_code")
	private Long userCode;

	private String userId;
	private String userPw;
	private String userName;
	private String userProfile;

	private Date joinDate;

	//자신이 학생으로 등록된 튜터링 목록
//	@Default
//	@OneToMany(mappedBy = "tstudent",cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Tutoring> tutors = new ArrayList<Tutoring>();

	public void addTutor(final Tutoring tutor) {
//		tutors.add(tutor);
		tutor.setStudent(this);
	}

	public void deleteTutor(final Tutoring tutor) {
//		tutors.remove(tutor);
		tutor.setStudent(null);
	}

//	//자신이 작성한 모든 리뷰 목록
//	@Default
//	@OneToMany(mappedBy = "rstudent",cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Review> reviews = new ArrayList<Review>();

	public void addReview(final Review review) {
//		reviews.add(review);
		review.setStudent(this);
	}

	public void deleteReview(final Review review) {
//		reviews.remove(review);
		review.setStudent(null);
	}
	

	@PrePersist
	public void beforeCreate() {
		this.joinDate = new Date();
	}

	@Override
	public String toString() {
		return "User [userCode=" + userCode + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userProfile=" + userProfile + ", joinDate=" + joinDate + "]";
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
