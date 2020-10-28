package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coder.demo.vo.Tutoring;

public interface TutoringDAO extends JpaRepository<Tutoring, Long>{

	List<Tutoring> findByStudentCode(Long code);
	
}
