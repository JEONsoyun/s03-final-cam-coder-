package com.coder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coder.demo.vo.Review;

public interface ReviewDAO  extends JpaRepository<Review, Long>{

	Review findByReviewCode(Long code);

	@Query("select r from Review r INNER JOIN r.teacher t where t.teacherCode = ?1 order by r.reviewCode")
	List<Review> findByTeacherCode(Long tcode);
}
