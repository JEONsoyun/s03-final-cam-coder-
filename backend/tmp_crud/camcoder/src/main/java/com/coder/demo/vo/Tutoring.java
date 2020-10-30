package com.coder.demo.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tutorings")
@EntityScan(basePackages = {"com.coder.demo.vo"})
public class Tutoring {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tutoringCode;
	
	private Long teacherCode;
	private Long studentCode;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	
	private String status;
	
	private int roomNum;
	
	private Date requestDate;
	
	@PrePersist
	public void beforeCreate() {
		this.requestDate = new Date();
	}
	
	public Tutoring() {
	}
	
	public Tutoring(Long tutoringCode, Long teacherCode, Long studentCode, Date startDate, Date endDate, String status,
			int roomNum) {
		this.tutoringCode = tutoringCode;
		this.teacherCode = teacherCode;
		this.studentCode = studentCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.roomNum = roomNum;
	}
	
	@Override
	public String toString() {
		return "Tutoring [tutoringCode=" + tutoringCode + ", teacherCode=" + teacherCode + ", studentCode="
				+ studentCode + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status
				+ ", roomNum=" + roomNum + ", requestDate=" + requestDate + "]";
	}
	public Long getTutoringCode() {
		return tutoringCode;
	}
	public void setTutoringCode(Long tutoringCode) {
		this.tutoringCode = tutoringCode;
	}
	public Long getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(Long teacherCode) {
		this.teacherCode = teacherCode;
	}
	public Long getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(Long studentCode) {
		this.studentCode = studentCode;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
}
