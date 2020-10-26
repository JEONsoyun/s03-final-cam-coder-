package com.coder.demo.component;
import javax.validation.Valid;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@Valid
@ToString
public class SignupRequest extends LoginRequest{
    @ApiModelProperty(required = true)
    @NotNull
    String name;
    @ApiModelProperty(required = true)
    String profile;

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
  
}

