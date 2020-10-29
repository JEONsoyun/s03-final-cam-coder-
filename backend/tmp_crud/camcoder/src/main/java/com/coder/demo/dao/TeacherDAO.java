package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.demo.vo.Like;
import com.coder.demo.vo.Teacher;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Long>{

	List<Teacher> findAll();
	Teacher findByTeacherCode(long code);
	Teacher findByUserCode(long code);
}
