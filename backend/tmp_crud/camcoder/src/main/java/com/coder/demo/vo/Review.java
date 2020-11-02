package com.coder.demo.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@Table(name = "reviews")
@EntityScan(basePackages = {"com.coder.demo.vo"})
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long reviewCode;
	private Long tutoringCode;
	private String evaluationContent;
	private Date evaluationDate;
	
	@ManyToOne
	@JoinColumn(name="student_code", referencedColumnName = "user_code")
	private User student;
	//private Long studentCode;
	
	@ManyToOne
	@JoinColumn(name = "teacher_code",referencedColumnName = "teacher_code")
	private Teacher teacher;
	//private Long teacherCode;	
	
	public Review() {
		super();
	}
	
	public Review(Long reviewCode, Long tutoringCode, String evaluationContent, Date evaluationDate, User student,
			Teacher teacher) {
		this.reviewCode = reviewCode;
		this.tutoringCode = tutoringCode;
		this.evaluationContent = evaluationContent;
		this.evaluationDate = evaluationDate;
		this.student = student;
		this.teacher = teacher;
	}

	/*
	public Review(Long reviewCode, Long tutoringCode, String evaluationContent, Date evaluationDate, Long studentCode,
			Long teacherCode) {
		super();
		this.reviewCode = reviewCode;
		this.tutoringCode = tutoringCode;
		this.evaluationContent = evaluationContent;
		this.evaluationDate = evaluationDate;
		this.studentCode = studentCode;
		this.teacherCode = teacherCode;
	}*/
	
	public Long getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(Long reviewCode) {
		this.reviewCode = reviewCode;
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
	/*
	public Long getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(Long studentCode) {
		this.studentCode = studentCode;
	}
	public Long getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(Long teacherCode) {
		this.teacherCode = teacherCode;
	}*/

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
