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

		//예외를 바꿀까??
		Like like = Optional.ofNullable(likedao.findByTeacherCodeAndUserCode(tcode, ucode)).orElseThrow(NotExistIdException::new);

		//likeCnt 감소
		tc.deleteLike(like);
		tdao.save(tc);
		
		likedao.deleteById(like.getLikeCode());
	}

	@Override
	public List<Like> selectMine(String userid) throws Exception{
		long ucode = Optional.ofNullable(userdao.findByUserId(userid)).map(User::getUserCode).orElseThrow(NotExistIdException::new);
		return likedao.findByUserCodeOrderByLikeDate(ucode);
	}

	@Override
	public String insert(LikeRequest like, String userid) throws Exception{
		long ucode = Optional.ofNullable(userdao.findByUserId(userid)).map(User::getUserCode).orElseThrow(NotExistIdException::new);

		long tcode = like.getTeacher();
		System.out.println(tdao.findByTeacherCode(tcode));
		Teacher tc = tdao.findById(tcode).get();
		if(tc==null) {
			return "fail";
		}
		//Teacher tc = Optional.ofNullable(tdao.findByTeacherCode(tcode)).orElseThrow(NotExistIdException::new);
		System.out.println(tc);
		
		Optional<Like> check = Optional.ofNullable(likedao.findByTeacherCodeAndUserCode(tcode, ucode));
		
		if(check.isEmpty()) {
			Like now = new Like(ucode, tc);
			//likeCnt 증가
			tc.addLike(now);
			tdao.save(tc);
			likedao.save(now);
			return "success";
		}else {
			
			tc.deleteLike(check.get());
			likedao.deleteById(check.get().getLikeCode());
			tdao.save(tc);
			return "remove";
		}
	}

	@Override
	public boolean isLike(Long code, String userid) throws Exception{
		long ucode = Optional.ofNullable(userdao.findByUserId(userid)).map(User::getUserCode).orElseThrow(NotExistIdException::new);
		return (likedao.findByTeacherCodeAndUserCode(code, ucode)!=null)? true: false;
	}	

}
