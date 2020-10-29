package com.coder.demo.component;
import javax.validation.Valid;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@Valid
@ToString
public class RegisterRequest extends LoginRequest{
    @ApiModelProperty(required = true)
	String intro;
	@ApiModelProperty(required = true)
	String expertise;
    @ApiModelProperty(required = true)
	Long price;
	@ApiModelProperty(required = true)
    String profile;
    @ApiModelProperty(required = true)
	String avaliableTime;

    /////////////////////////////////////////////////////////
    @ApiModelProperty(required = true)
    Integer sorttype;
    
    
    public Integer getSorttype() {
		return sorttype;
	}
	public void setSorttype(Integer sorttype) {
		this.sorttype = sorttype;
	}
	
	@ApiModelProperty(required=true)
	String keywords;
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	////////////////////////////////////////////////////////
	
	
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getAvaliableTime() {
		return avaliableTime;
	}
	public void setAvaliableTime(String avaliableTime) {
		this.avaliableTime = avaliableTime;
	}
}

