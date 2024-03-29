package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coder.demo.vo.Tutoring;

public interface TutoringDAO extends JpaRepository<Tutoring, Long>{

	Tutoring findByTutoringCode(Long code);
	
	@Query("select r from Tutoring r INNER JOIN r.student s where s.userCode = ?1 order by r.status asc, r.tutoringCode asc")
	List<Tutoring> findByStudentCode(Long code);
	
	@Query("select r from Tutoring r INNER JOIN r.teacher t where t.teacherCode = ?1 order by r.status asc, r.tutoringCode asc")
	List<Tutoring> findByTeacherCode(Long code);
}
