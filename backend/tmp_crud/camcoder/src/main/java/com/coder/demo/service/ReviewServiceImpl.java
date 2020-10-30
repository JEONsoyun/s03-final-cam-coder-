package com.coder.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.demo.dao.ReviewDAO;
import com.coder.demo.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDAO reviewdao;

	@Override
	public String insert(Review review) {
		try {
			reviewdao.save(review);
		}catch(Exception e) {
			return "review insert fail";
		}
		return "insert review";
	}

	@Override
	public List<Review> selectTeacher(Long teacherCode) {
		//return reviewdao.findByTeacherCode(teacherCode);
		return null;
	}

	@Override
	public String deleteReview(Long reviewCode) {
		try {
			reviewdao.deleteById(reviewCode);
		}catch( Exception e) {
			return "review insert Fail";
		}
		return "delete review";
	}
	
	
	

}
