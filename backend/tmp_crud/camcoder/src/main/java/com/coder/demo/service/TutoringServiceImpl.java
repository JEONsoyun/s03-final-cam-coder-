package com.coder.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.demo.dao.TutoringDAO;
import com.coder.demo.vo.Tutoring;

@Service
public class TutoringServiceImpl implements TutoringService {
	
	@Autowired
	TutoringDAO tutoringdao;
	
	@Override
	public String insert(Tutoring tutoring) {
		try {
			tutoringdao.save(tutoring);
		}catch (Exception e) {
			return "Tutoring insert fail";
		}
		return "insert Tutoring";
	}

	@Override
	public Tutoring selectOne(Long tutoringCode) {
		return tutoringdao.findById(tutoringCode).get();
	}

	@Override
	public List<Tutoring> selectAll(Long code) {
		return tutoringdao.findByStudentCode(code);
	}
	
	

}
