package com.coder.demo.service;

import java.util.List;

import com.coder.demo.vo.Tutoring;

public interface TutoringService  {

	String insert(Tutoring tutoring);

	List<Tutoring> selectAll(Long code);

	Tutoring selectOne(Long tutoringCode);

}
