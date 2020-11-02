package com.coder.demo.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.component.TutorRegistRequest;
import com.coder.demo.dao.TutoringDAO;
import com.coder.demo.service.ReviewService;
import com.coder.demo.vo.Review;
import com.coder.demo.vo.Tutoring;

@RestController
public class ReviewController {	
	@Autowired
	ReviewService reviewService;
	@Autowired
	TutoringDAO tutoringdao;
	
	@PostMapping(value="/reviews")//리뷰 등록
	public String insert(@RequestBody TutorRegistRequest review, HttpServletRequest request)throws Exception {
		String id = (String)(request.getAttribute("loginUserId"));
		reviewService.insert(review, id);
		return "리뷰 등록 완료";
	}
	
	@GetMapping(value="/reviews")//해당 선생님에 대한 리뷰 목록보기
	public List<Review> selectTeacher() {
		Long teacherCode = (long)3; 
		System.out.println(teacherCode);
		return reviewService.selectTeacher(teacherCode);
	}
	@DeleteMapping(value="/reviews/{reviewCode}")//유저가 쓴 해당 선생님에 대한 리뷰 삭제
	public String deleteReview(@PathVariable Long reviewCode) {
		Long studentCode = (long)7;
		
		return reviewService.deleteReview(reviewCode);
	}
	/*@PutMapping(value="/reviews/{reviewCode}")//유저가 쓴 해당 선생님에 대한 리뷰 수정
	public String updateReview(@PathVariable Long reviewCode,@RequestBody Review review) {
		review.setReviewCode(reviewCode);
		return reviewService.insert(review);
	}*/
}
