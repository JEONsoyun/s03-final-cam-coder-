package com.coder.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.demo.component.LikeRequest;
import com.coder.demo.dao.LikeDAO;
import com.coder.demo.dao.TeacherDAO;
import com.coder.demo.dao.UserDAO;
import com.coder.demo.exception.NotExistIdException;
import com.coder.demo.vo.Like;
import com.coder.demo.vo.Teacher;
import com.coder.demo.vo.User;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	LikeDAO likedao;
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	TeacherDAO tdao;

	@Override
	public void delete(Long tcode, String id) throws Exception{
		Teacher tc = Optional.ofNullable(tdao.findByTeacherCode(tcode)).orElseThrow(NotExistIdException::new);
		long ucode = Optional.ofNullable(userdao.findByUserId(id)).map(User::getUserCode).orElseThrow(NotExistIdException::new);
		
		Like now = new Like(ucode, tc);
		//likeCnt 감소
		//tc.deleteLike(now);
		//tdao.save(tc);
		
		//likedao.deleteById(tcode, ucode);
	}

	@Override
	public List<Like> selectMine(String userid) throws Exception{
		long ucode = Optional.ofNullable(userdao.findByUserId(userid)).map(User::getUserCode).orElseThrow(NotExistIdException::new);
		return likedao.findByUserCodeOrderByLikeDate(ucode);
	}

	@Override
	public void insert(LikeRequest like, String userid) throws Exception{
		long ucode = Optional.ofNullable(userdao.findByUserId(userid)).map(User::getUserCode).orElseThrow(NotExistIdException::new);
		
		long tcode = like.getTeacher();
		Teacher tc = Optional.ofNullable(tdao.findByTeacherCode(tcode)).orElseThrow(NotExistIdException::new);
		
		Like now = new Like(ucode, tc);
		//likeCnt 증가
		tc.addLike(now);
		tdao.save(tc);
	}
	
	

}
