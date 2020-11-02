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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tutorings")
@EntityScan(basePackages = {"com.coder.demo.vo"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Tutoring {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tutoringCode;
	
	@ManyToOne
	@JoinColumn(name = "teacher_code",referencedColumnName = "teacher_code")
	private Teacher teacher;
	
	@ManyToOne
	@JoinColumn(name="student_code", referencedColumnName = "user_code")
	private User student;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	
	//private String status;
	private int status;
	
	private int roomNum;
	
	private Date requestDate;
	
	@PrePersist
	public void beforeCreate() {
		this.requestDate = new Date();
	}
	
	public Tutoring() {
	}
	
	public Tutoring(Teacher teacher, User student, Date startDate, Date endDate, int status, int roomNum) {
		this.teacher = teacher;
		this.student = student;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.roomNum = roomNum;
	}

	public Tutoring(Date startDate, Date endDate, int status, int roomNum) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.roomNum = roomNum;
	}
	
	/*public Tutoring(Teacher teacher, User student, Date startDate, Date endDate, String status, int roomNum) {
		this.teacher = teacher;
		this.student = student;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.roomNum = roomNum;
	}

	public Tutoring(Date startDate, Date endDate, String status, int roomNum) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.roomNum = roomNum;
	}*/
	
	public Long getTutoringCode() {
		return tutoringCode;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
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
	/*public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
	
}
