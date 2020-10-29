package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coder.demo.vo.Like;

@Repository
public interface LikeDAO extends JpaRepository<Like, Long>{

	List<Like> findByTeacherCode(Long code);

	Like findByTeacherCodeAndUserCode(Long teacherCode, Long userCode);

}
