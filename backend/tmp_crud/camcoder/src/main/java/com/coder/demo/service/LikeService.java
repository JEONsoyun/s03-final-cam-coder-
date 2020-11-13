package com.coder.demo.service;

import java.util.List;

import com.coder.demo.component.LikeRequest;
import com.coder.demo.vo.Like;

public interface LikeService {
	public List<Like> selectMine(String userid)throws Exception;
	public String insert(LikeRequest like, String userid)throws Exception;
	public void delete(Long code, String id)throws Exception;
}
