package com.coder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coder.demo.service.LikeService;
import com.coder.demo.vo.Like;

@RestController
public class LikeController {
	
	
	@Autowired
	LikeService likeService;
	
	@PostMapping(value="/likes")
	public String insert(@RequestBody Like like) {
		System.out.println(like);
		return likeService.insert(like);
	}
	@GetMapping(value="/likes/{code}")
	public List<Like> selectAll(@PathVariable Long code) {
		System.out.println(code);
		return likeService.selectAll(code);
	}
	@DeleteMapping(value="/likes/{likeCode}")
	public void deleteLike(@PathVariable Long likeCode) {
		likeService.delete(likeCode);
	}
}
