package com.blog.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.blog.model.Post;
import com.blog.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostService postservice;

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPostHandler() {
		List<Post> posts = postservice.getAllPost();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostHandler(@PathVariable Integer id) {
		Post posts = postservice.getPostById(id);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@PostMapping("/posts")
	public ResponseEntity<Post> postPostHandler(@Valid @RequestBody Post post) {
		Post posts = postservice.createNewPost(post);
		return new ResponseEntity<>(posts, HttpStatus.ACCEPTED);
	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePostHandler(@PathVariable Integer id,@Valid @RequestBody Post post) {
		Post posts = postservice.updatePost(id, post);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Post> deletePostHandler(@PathVariable Integer id) {
		Post posts = postservice.deletePost(id);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

}
