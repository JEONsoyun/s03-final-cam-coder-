package com.coder.demo.component;
import javax.validation.Valid;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@Valid
@ToString
public class LoginRequest {
    @ApiModelProperty(required = true)
    @NotNull
    String id;
    @ApiModelProperty(required = true)
    @NotNull
    String pw;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}  
}

