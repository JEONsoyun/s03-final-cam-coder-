package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coder.demo.vo.Like;

@Repository
public interface LikeDAO extends JpaRepository<Like, Long>{

	List<Like> findByUserCodeOrderByLikeDate(Long code);

	@Query("select L from Like L INNER JOIN L.teacher t where L.userCode = ?2 and t.teacherCode = ?1")
	Like findByTeacherCodeAndUserCode(Long teacherCode, Long userCode);

	//@Query("delete L from Like L INNER JOIN L.teacher t where L.userCode = ?2 and t.teacherCode = ?1")
	//void deleteById(Long tcode, Long ucode);
}
