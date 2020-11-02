package com.coder.demo.service;

import java.util.List;

import com.coder.demo.component.TutorRegistRequest;
import com.coder.demo.vo.Review;
import com.coder.demo.vo.Tutoring;

public interface ReviewService {
	List<Review> selectTeacher(Long teacherCode);

	String deleteReview(Long reviewCode);

	void insert(TutorRegistRequest review, String id) throws Exception;

	void update(Long rcode, TutorRegistRequest review, String id) throws Exception;

}
