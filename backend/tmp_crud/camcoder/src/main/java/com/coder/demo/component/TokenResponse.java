package com.coder.demo.component;

import io.swagger.annotations.ApiModelProperty;

public class TokenResponse {
	@ApiModelProperty(value = "token", position = 1)
	String token;
	@ApiModelProperty(value = "tokenType", position = 2)
	String tokenType;
	
	public TokenResponse(String token, String tokenType) {
		this.token = token;
		this.tokenType = tokenType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}	

	
}
