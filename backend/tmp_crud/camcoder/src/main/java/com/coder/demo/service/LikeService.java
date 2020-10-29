package com.coder.demo.service;

import java.util.List;

import com.coder.demo.vo.Like;

public interface LikeService {
	public List<Like> selectAll(Long code);
	public String insert(Like like);
	public void delete(Long code);
}
