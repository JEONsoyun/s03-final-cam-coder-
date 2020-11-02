package com.coder.demo.component;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class TutorRegistRequest {
	@ApiModelProperty(required=true)
	Long teacher_code;

	@ApiModelProperty(required=true)
	Date start;

	@ApiModelProperty(required=true)
	Date end;
    /////////////for 상태 /////////////////////
    @ApiModelProperty(required = true)
    Integer status;
    
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	///////////////////////////////////////////////
	@ApiModelProperty(required = true)
	String content;
	@ApiModelProperty(required = true)
	Long tutoring_code;
	///////////////////////////////////////////////
	
	public Long getTutoring_code() {
		return tutoring_code;
	}
	public void setTutoring_code(Long tutoring_code) {
		this.tutoring_code = tutoring_code;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getTeacher_code() {
		return teacher_code;
	}
	public void setTeacher_code(Long teacher_code) {
		this.teacher_code = teacher_code;
	}
}
