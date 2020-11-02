package com.coder.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.component.TutorRegistRequest;
import com.coder.demo.exception.NotExistIdException;
import com.coder.demo.service.TutoringService;
import com.coder.demo.vo.Tutoring;

@RestController
public class TutoringController {
	
	
	@Autowired
	TutoringService tutoringService;
	
	@PostMapping(value="/tutorings")//수업 요청
	public String insert(@RequestBody TutorRegistRequest regist, HttpServletRequest request) throws Exception{
		//날짜, 시간, 금액, 내용, 선생님 코드
		String id = (String)(request.getAttribute("loginUserId"));
		tutoringService.insert(regist, id);
		return "요청 완료";
	}
	
	@GetMapping(value="/tutorings/{tutoringCode}")//해당 수업 정보 불러오기
	public Tutoring getOneTutoring(@PathVariable Long tutoringCode) {
		return tutoringService.selectOne(tutoringCode);
	}
	
	@PutMapping(value="/tutorings/{tutoringCode}")//수업 상태 변경하기(강사, 학생 모두 가능)
	public String updateLike(@PathVariable Long tutoringCode, @RequestBody TutorRegistRequest regist, HttpServletRequest request) throws Exception {
		String id = (String)(request.getAttribute("loginUserId"));
		tutoringService.update(regist, id, tutoringCode);
		return "변경 완료";
	}
	
	@GetMapping(value="/tutorings/0/teacher")
	public List<Tutoring> selectAllTutee(HttpServletRequest request) throws NotExistIdException {//유저의 수업 목록 보기 과외 현황
		String id = (String)(request.getAttribute("loginUserId"));
		return tutoringService.selectAllTutee(id);
	}	
	
	@GetMapping(value="/tutorings/0/student")
	public List<Tutoring> selectAllTutor(HttpServletRequest request) throws NotExistIdException{//유저의 수업 목록 보기 과외 현황
		String id = (String)(request.getAttribute("loginUserId"));
		return tutoringService.selectAllTutor(id);
	}
}
