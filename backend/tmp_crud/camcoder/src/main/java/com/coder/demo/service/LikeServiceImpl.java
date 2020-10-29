package com.coder.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.demo.dao.LikeDAO;
import com.coder.demo.vo.Like;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	LikeDAO likedao;
	
	@Override
	public List<Like> selectAll(Long code) {
		
		return likedao.findByTeacherCode(code);
	}

	@Override
	public String insert(Like like) {
		if(null== likedao.findByTeacherCodeAndUserCode(like.getTeacherCode(), like.getUserCode())) {
			likedao.save(like);
			return "insert";
		}else {
			return "insert Fail";
		}
		
	}

	@Override
	public void delete(Long code) {
		// TODO Auto-generated method stub
		likedao.deleteById(code);
	}
	
	

}
