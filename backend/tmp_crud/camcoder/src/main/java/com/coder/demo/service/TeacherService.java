package com.coder.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.coder.demo.component.RegisterRequest;
import com.coder.demo.vo.Teacher;

//2.CLIENT(Controller)를 위한 인터페이스
public interface TeacherService {
	public List<Teacher> selectAll();
	public Teacher selectOneByCode(long teacherCode);//상세보기
	public void insert(RegisterRequest register, String id) throws Exception; //teachers
	public void update(@Valid RegisterRequest u, String id);//update
	public void delete(String id);
	public List<Teacher> sortByLikes();
	public List<Teacher> sortByCnt();
	public List<Teacher> contains();	
}
