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
			
			tdao.save(new Teacher(userdao.findByUserId(id), intro, expertise, price, profile, time));
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
		return Optional.ofNullable(tdao.findByTeacherCode(teacherCode)).orElse(new Teacher());
	}	
	
	@Override
	public List<Teacher> sortBy(int type){
		List<Teacher> result;
		
		if(type == 0) {
			result = tdao.findAllByOrderByStudentCntDesc();
		}else {
			result = tdao.findAllByOrderByLikeCntDesc();
		}
		
		return result;
	}

	
	
	@Override
	public List<Teacher> selectAll() {
		return tdao.findAll();
	}

	
	@Override
	public List<Teacher> contain(String keyword) {
		return tdao.findContainKeyword(keyword);
	}

}
