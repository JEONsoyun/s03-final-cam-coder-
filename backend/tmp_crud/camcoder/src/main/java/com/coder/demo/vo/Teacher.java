package com.coder.demo.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.coder.demo.component.AtomicLongConverter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teachers")
@EntityScan(basePackages = {"com.coder.demo.vo"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//저장할때만 되나?
	@Column(name="teacher_code")
	private Long teacherCode;
	
	//Long userCode;
	@OneToOne
	@JoinColumn(name="user_code", referencedColumnName = "user_code")
	private User user;
	
	private String intro;
	private String expertise;
	private Long price;
	private String profile;
	@Convert(converter = AtomicLongConverter.class)
	private AtomicLong likeCnt;
	//Long likeCnt;
	private String avaliableTime;
	@Convert(converter = AtomicLongConverter.class)
	private AtomicLong studentCnt;
	//Long studentCnt;
	
	@PrePersist
	public void beforeCreate() {
		this.likeCnt = new AtomicLong();
		this.studentCnt = new AtomicLong();		
	}
///////////////////////////////////////////////////////////////////////////////////////
	@Default
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Like> likes = new ArrayList<Like>();
	
	public void addLike(final Like like) {
		likes.add(like);
		this.likeCnt.incrementAndGet();
		like.setTeacher(this);
	}
	
	public void deleteLike(final Like like) {
		likes.remove(like);
		this.likeCnt.decrementAndGet();
		like.setTeacher(null);
	}

////////////////////////////////////////////////////////////////////////////////////////////////	
	public Teacher(User userCode, String intro, String expertise, Long price, String profile,
			String avaliableTime) {
		this.user = userCode;
		this.intro = intro;
		this.expertise = expertise;
		this.price = price;
		this.profile = profile;
		this.avaliableTime = avaliableTime;
	}
	
	public Teacher() {
	}
	
	public Long getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(Long teacherCode) {
		this.teacherCode = teacherCode;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getAvaliableTime() {
		return avaliableTime;
	}
	public void setAvaliableTime(String avaliableTime) {
		this.avaliableTime = avaliableTime;
	}

	public AtomicLong getLikeCnt() {
		return likeCnt;
	}

	public AtomicLong getStudentCnt() {
		return studentCnt;
	}

	public void setLikeCnt(AtomicLong likeCnt) {
		this.likeCnt = likeCnt;
	}

	public void setStudentCnt(AtomicLong studentCnt) {
		this.studentCnt = studentCnt;
	}
	
	@Override
	public String toString() {
		return "Teacher [teacherCode=" + teacherCode + ", userCode=" + user + ", intro=" + intro + ", expertise="
				+ expertise + ", price=" + price + ", profile=" + profile + ", likeCnt=" + likeCnt + ", avaliableTime="
				+ avaliableTime + ", studentCnt=" + studentCnt + "]";
	}	
}