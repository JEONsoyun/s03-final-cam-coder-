package com.coder.demo.component;

import javax.validation.Valid;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@Valid
@ToString
public class MessageRequest {
	@ApiModelProperty(required = true)
	@NotNull
	String content;
	@ApiModelProperty(required = true)
	@NotNull
	String receiver;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
}
