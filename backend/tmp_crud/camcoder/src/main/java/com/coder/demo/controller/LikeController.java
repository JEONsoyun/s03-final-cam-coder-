package com.coder.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.component.LikeRequest;
import com.coder.demo.service.LikeService;
import com.coder.demo.vo.Like;

@RestController
public class LikeController {
	
	
	@Autowired
	LikeService likeService;
	
	@PostMapping(value="/likes")
	public String insert(@RequestBody LikeRequest like, HttpServletRequest request) throws Exception{
		return likeService.insert(like, (String)(request.getAttribute("loginUserId")));
	}
	
	//유저가 좋아요한 목록
	@GetMapping(value="/likes")
	public List<Like> selectAll(HttpServletRequest request) throws Exception{
		return likeService.selectMine((String)(request.getAttribute("loginUserId")));
	}
	@GetMapping(value="/likes/{Code}")
	public boolean isLike(@PathVariable Long Code, HttpServletRequest request) throws Exception{
		//likeService.isLike(Code, (String)(request.getAttribute("loginUserId")));
		return likeService.isLike(Code, (String)(request.getAttribute("loginUserId")));
	}
	@DeleteMapping(value="/likes/{Code}")
	public String deleteLike(@PathVariable Long Code, HttpServletRequest request) throws Exception{
		likeService.delete(Code, (String)(request.getAttribute("loginUserId")));
		return "좋아요 취소";
	}
}
