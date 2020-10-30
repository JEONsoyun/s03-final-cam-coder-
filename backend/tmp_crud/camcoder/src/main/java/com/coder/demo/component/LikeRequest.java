package com.coder.demo.component;
import javax.validation.Valid;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@Valid
@ToString
public class LikeRequest extends LoginRequest{
    @ApiModelProperty(required = true)
	Long teacher;

	public Long getTeacher() {
		return teacher;
	}

	public void setTeacher(Long teacher) {
		this.teacher = teacher;
	}

    
}

