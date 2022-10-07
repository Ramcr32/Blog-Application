package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Comment>> getAllCommentsHandler(@PathVariable Integer postId) {
		List<Comment> comments = commentservice.getAllCommentOfPost(postId);
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}

	@GetMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<Comment> getCommentsHandler(@PathVariable Integer postId, @PathVariable Integer Id) {
		Comment comments = commentservice.getCommentById(Id);
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}

	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<Comment> newCommentHandler(@PathVariable Integer postId, @RequestBody Comment comment) {
		Comment c = commentservice.newComment(postId,comment);
		return new ResponseEntity<>(c, HttpStatus.ACCEPTED);
	}

	@PutMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<Comment> updateCommentHandler(@PathVariable Integer postId, @PathVariable Integer id,
			@RequestBody Comment comment) {
		Comment c = commentservice.updateComment(id, comment);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@DeleteMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<Comment> deleteCommentHandler(@PathVariable Integer postId, @PathVariable Integer id) {
		Comment c = commentservice.deleteComment(id);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
}
