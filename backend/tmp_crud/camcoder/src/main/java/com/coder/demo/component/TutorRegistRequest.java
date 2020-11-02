package com.coder.demo.component;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class TutorRegistRequest {
	@ApiModelProperty(required = true)
	String content;

	@ApiModelProperty(required=true)
	Long teacher_code;

	@ApiModelProperty(required=true)
	Date start;

	@ApiModelProperty(required=true)
	Date end;

    @ApiModelProperty(required = true)
	Long price;
    
    @ApiModelProperty(required = true)
    Integer status;
    
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
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
