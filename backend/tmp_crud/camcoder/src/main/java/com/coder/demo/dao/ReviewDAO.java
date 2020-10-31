package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coder.demo.vo.Review;

public interface ReviewDAO  extends JpaRepository<Review, Long>{

	//List<Review> findByTeacherCode(Long teacherCode);

}
