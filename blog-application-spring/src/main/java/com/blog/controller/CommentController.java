package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.Comment;
import com.blog.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	@Autowired
	private CommentService commentservice;
	
	@GetMapping("/posts/{postId}/comments")
	public ResponseEntity<List<Comment>> getAllCommentsHandler(Integer postId){
		List<Comment> comments = commentservice.getAllCommentOfPost(postId);
		return new ResponseEntity<List<Comment>>(comments,HttpStatus.OK);
	}
}
