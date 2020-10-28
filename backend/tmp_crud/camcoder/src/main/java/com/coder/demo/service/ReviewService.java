package com.coder.demo.service;

import java.util.List;

import com.coder.demo.vo.Review;
import com.coder.demo.vo.Tutoring;

public interface ReviewService {

	String insert(Review review);

	List<Review> selectTeacher(Long teacherCode);

	String deleteReview(Long reviewCode);

}
