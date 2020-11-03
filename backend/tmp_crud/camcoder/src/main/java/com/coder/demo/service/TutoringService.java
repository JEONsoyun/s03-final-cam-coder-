package com.coder.demo.service;

import java.util.List;

import com.coder.demo.component.TutorRegistRequest;
import com.coder.demo.exception.NotExistIdException;
import com.coder.demo.vo.Tutoring;

public interface TutoringService  {

	Tutoring selectOne(Long tutoringCode);

	void insert(TutorRegistRequest regist, String id) throws Exception;

	void update(TutorRegistRequest regist, String id, Long tutoringCode) throws Exception;

	List<Tutoring> selectAllTutee(String id) throws NotExistIdException;

	List<Tutoring> selectAllTutor(String id) throws NotExistIdException;

}
