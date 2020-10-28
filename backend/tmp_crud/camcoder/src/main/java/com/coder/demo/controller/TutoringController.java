package com.coder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.service.TutoringService;
import com.coder.demo.vo.Tutoring;

@RestController
public class TutoringController {
	
	
	@Autowired
	TutoringService tutoringService;
	
	@PostMapping(value="/tutorings")
	public String insert(@RequestBody Tutoring tutoring) {
		System.out.println(tutoring);
		return tutoringService.insert(tutoring);
	}
	@GetMapping(value="/tutorings")
	public List<Tutoring> selectAll() {
		Long studentcode = (long)7; 
		System.out.println(studentcode);
		return tutoringService.selectAll(studentcode);
	}
	@GetMapping(value="/tutorings/{tutoringCode}")
	public Tutoring getOneTutoring(@PathVariable Long tutoringCode) {
		return tutoringService.selectOne(tutoringCode);
	}
	@PostMapping(value="/tutorings/{tutoringCode}")
	public String updateLike(@PathVariable Long tutoringCode,@RequestBody Tutoring tutoring) {
		tutoring.setTutoringCode(tutoringCode);
		return tutoringService.insert(tutoring);
	}
}
