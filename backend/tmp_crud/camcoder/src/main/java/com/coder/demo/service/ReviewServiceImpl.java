package com.coder.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.coder.demo.component.TutorRegistRequest;
import com.coder.demo.dao.ReviewDAO;
import com.coder.demo.dao.TeacherDAO;
import com.coder.demo.dao.TutoringDAO;
import com.coder.demo.dao.UserDAO;
import com.coder.demo.exception.NotExistIdException;
import com.coder.demo.vo.Review;
import com.coder.demo.vo.Teacher;
import com.coder.demo.vo.Tutoring;
import com.coder.demo.vo.User;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDAO reviewdao;

	@Autowired
	TutoringDAO tutoringdao;

	@Autowired
	UserDAO userdao;

	@Autowired
	TeacherDAO tdao;

	@Override
	public void insert(TutorRegistRequest review, String id) throws Exception{
		User student = Optional.ofNullable(userdao.findByUserId(id)).orElseThrow(NotExistIdException::new);		

		Long tutoring_code = Optional.ofNullable(review).map(TutorRegistRequest::getTutoring_code).orElse((long)0);
		Tutoring tutoring = Optional.ofNullable(tutoringdao.findByTutoringCode(tutoring_code)).orElseThrow(() -> new NotExistIdException("tutoring"));
		
		if(tutoring.getStudent().getUserCode() != student.getUserCode()) {
			throw new NotExistIdException("tutoring");
		}
		
		if(tutoring.getStatus() != 2) {
			//완료되지 않은 수업을 평가 불가
			throw new NotExistIdException("Finished tutoring");
		}
		
		Teacher tc = Optional.ofNullable(tdao.findByTeacherCode(tutoring.getTeacher().getTeacherCode())).orElseThrow(() -> new NotExistIdException("teacher"));

		try {
			String content = Optional.of(review).map(TutorRegistRequest::getContent).orElse("");
			Review rv = new Review(tutoring_code, content, student, tc);

			tc.addReview(rv);
			//student.addReview(rv);
			reviewdao.save(rv);
		}catch(DataAccessException ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause().getMessage());
		}
	}
	
	@Override
	public void update(Long rcode, TutorRegistRequest review, String id) throws Exception {
		User student = Optional.ofNullable(userdao.findByUserId(id)).orElseThrow(NotExistIdException::new);		
		
		Review rv = Optional.ofNullable(reviewdao.findByReviewCode(rcode)).orElseThrow(() -> new NotExistIdException("review"));
		Teacher tc = Optional.ofNullable(tdao.findByTeacherCode(rv.getTeacher().getTeacherCode())).orElseThrow(() -> new NotExistIdException("teacher"));
		
		if(rv.getStudent().getUserCode() != student.getUserCode()) {
			throw new NotExistIdException("review");
		}
		
		try {
			String content = Optional.of(review).map(TutorRegistRequest::getContent).orElse("");
			rv.setEvaluationContent(content);
			rv.setEvaluationDate(new Date());
			reviewdao.save(rv);
		}catch(DataAccessException ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause().getMessage());
		}		
	}
	
	@Override
	public void deleteReview(Long rcode, String id) throws Exception {
		User student = Optional.ofNullable(userdao.findByUserId(id)).orElseThrow(NotExistIdException::new);		
		
		Review rv = Optional.ofNullable(reviewdao.findByReviewCode(rcode)).orElseThrow(() -> new NotExistIdException("review"));
		
		if(rv.getStudent().getUserCode() != student.getUserCode()) {
			throw new NotExistIdException("review");
		}
		try {
			reviewdao.delete(rv);
		}catch(DataAccessException ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause().getMessage());
		}
	}
	
	@Override
	public List<Review> selectTeacher(Long teacherCode) {
		return reviewdao.findByTeacherCode(teacherCode);
	}
}
