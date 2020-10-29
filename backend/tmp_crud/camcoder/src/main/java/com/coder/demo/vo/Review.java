package com.coder.demo.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Long studentCode;
	private Long teacherCode;
	@Override
	public String toString() {
		return "Review [reviewCode=" + reviewCode + ", tutoringCode=" + tutoringCode + ", evaluationContent="
				+ evaluationContent + ", evaluationDate=" + evaluationDate + ", studentCode=" + studentCode
				+ ", teacherCode=" + teacherCode + "]";
	}
	public Review() {
		super();
	}
	public Review(Long reviewCode, Long tutoringCode, String evaluationContent, Date evaluationDate, Long studentCode,
			Long teacherCode) {
		super();
		this.reviewCode = reviewCode;
		this.tutoringCode = tutoringCode;
		this.evaluationContent = evaluationContent;
		this.evaluationDate = evaluationDate;
		this.studentCode = studentCode;
		this.teacherCode = teacherCode;
	}
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
	}
	
	
}
