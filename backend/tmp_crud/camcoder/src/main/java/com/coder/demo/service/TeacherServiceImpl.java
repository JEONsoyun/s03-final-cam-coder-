package com.coder.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.coder.demo.component.RegisterRequest;
import com.coder.demo.dao.TeacherDAO;
import com.coder.demo.dao.UserDAO;
import com.coder.demo.exception.RepeatException;
import com.coder.demo.vo.Teacher;

//3.Service 객체
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherDAO tdao;
	
	@Autowired
	UserDAO userdao;

	@Override
	public void insert(RegisterRequest register, String id) throws Exception {
		Long code = userdao.findByUserId(id).getUserCode();		
		
		if(Optional.ofNullable(tdao.findByUserCode(code)).isPresent()) {
			throw new RepeatException();
		}
		
		try {
			String intro = Optional.of(register).map(RegisterRequest::getIntro).orElse("");
			String expertise = Optional.of(register).map(RegisterRequest::getExpertise).orElse("");
			Long price = Optional.of(register).map(RegisterRequest::getPrice).get();
			String profile = Optional.of(register).map(RegisterRequest::getProfile).orElse("");
			String time = Optional.of(register).map(RegisterRequest::getAvaliableTime).orElse("");
			
			tdao.save(new Teacher(code, intro, expertise, price, profile, time));
		}catch(DataAccessException ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause().getMessage());
		}
	}

	@Override
	public void update(@Valid RegisterRequest register, String id) {
		Long code = userdao.findByUserId(id).getUserCode();		
		Teacher now = tdao.findByUserCode(code);
		
		try {
			now.setIntro(Optional.of(register).map(RegisterRequest::getIntro).orElse(now.getIntro()));
			now.setExpertise(Optional.of(register).map(RegisterRequest::getExpertise).orElse(now.getExpertise()));
			now.setPrice(Optional.of(register).map(RegisterRequest::getPrice).orElse(now.getPrice()));
			now.setProfile(Optional.of(register).map(RegisterRequest::getProfile).orElse(now.getProfile()));
			now.setAvaliableTime(Optional.of(register).map(RegisterRequest::getAvaliableTime).orElse(now.getAvaliableTime()));
			
			tdao.save(now);
		}catch(DataAccessException ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause().getMessage());
		}		
	}

	@Override
	public void delete(String id) {
		Long code = userdao.findByUserId(id).getUserCode();		
		Teacher now = tdao.findByUserCode(code);
		
		tdao.delete(now);
	}

	@Override
	public Teacher selectOneByCode(long teacherCode) {
		//exception필요한가?
		return tdao.findByTeacherCode(teacherCode);
	}
	
	
	@Override
	public List<Teacher> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Teacher> sortByLikes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> sortByCnt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> contains() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
