package com.coder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.service.TutoringService;
import com.coder.demo.vo.Tutoring;

@RestController
public class TutoringController {
	
	
	@Autowired
	TutoringService tutoringService;
	
	@PostMapping(value="/tutorings")//수업 요청
	public String insert(@RequestBody Tutoring tutoring) {
		System.out.println(tutoring);
		return tutoringService.insert(tutoring);
	}
	@GetMapping(value="/tutorings")
	public List<Tutoring> selectAll() {//유저의 수업 목록 보기 과외 현황
		Long studentcode = (long)7; 
		System.out.println(studentcode);
		return tutoringService.selectAll(studentcode);
	}
	@GetMapping(value="/tutorings/{tutoringCode}")//해당 수업 정보 불러오기
	public Tutoring getOneTutoring(@PathVariable Long tutoringCode) {
		return tutoringService.selectOne(tutoringCode);
	}
	@PutMapping(value="/tutorings/{tutoringCode}")//수업 상태 변경하기(강사, 학생 모두 가능)
	public String updateLike(@PathVariable Long tutoringCode,@RequestBody Tutoring tutoring) {
		tutoring.setTutoringCode(tutoringCode);
		return tutoringService.insert(tutoring);
	}
}
