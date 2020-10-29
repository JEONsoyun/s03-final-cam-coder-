package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coder.demo.vo.Teacher;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Long>{

	List<Teacher> findAll();
	Teacher findByTeacherCode(long code);
	Teacher findByUserCode(long code);
	List<Teacher> findAllByOrderByLikeCntDesc();
	List<Teacher> findAllByOrderByStudentCntDesc();	
	
	@Query("select t from Teacher t where t.expertise like %?1% order by t.studentCnt desc, t.teacherCode asc")
	List<Teacher> findContainKeyword(String keyword);
	
	List<Teacher> findByExpertiseLike(String keyword);
}
