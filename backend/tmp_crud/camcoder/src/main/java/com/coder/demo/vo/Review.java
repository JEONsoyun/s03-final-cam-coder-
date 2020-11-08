package com.coder.demo.vo;

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
@Table(name = "reviews")
@EntityScan(basePackages = {"com.coder.demo.vo"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long reviewCode;
	private Long tutoringCode;
	private String evaluationContent;
	private Date evaluationDate;
	
	@ManyToOne
	@JoinColumn(name="student_code", referencedColumnName = "user_code")
	private User rstudent;
	
	@ManyToOne
	@JoinColumn(name = "teacher_code",referencedColumnName = "teacher_code")
	private Teacher rteacher;
	
	@PrePersist
	public void beforeCreate() {
		this.evaluationDate = new Date();
	}
	
	public Review() {
		super();
	}
	
	public Review(Long tutoringCode, String evaluationContent, User student,
			Teacher teacher) {
		this.tutoringCode = tutoringCode;
		this.evaluationContent = evaluationContent;
		this.rstudent = student;
		this.rteacher = teacher;
	}
	
	public Long getReviewCode() {
		return reviewCode;
	}

	public Long getTutoringCode() {
		return tutoringCode;
	}
	public void setTutoringCode(Long tutoringCode) {
		this.tutoringCode = tutoringCode;
	}
	public String getEvaluationContent() {
		return evaluationContent;
	}
	public void setEvaluationContent(String evaluationContent) {
		this.evaluationContent = evaluationContent;
	}
	public Date getEvaluationDate() {
		return evaluationDate;
	}
	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public User getStudent() {
		return rstudent;
	}

	public void setStudent(User student) {
		this.rstudent = student;
	}

	public Teacher getTeacher() {
		return rteacher;
	}

	public void setTeacher(Teacher teacher) {
		this.rteacher = teacher;
	}
	
}
