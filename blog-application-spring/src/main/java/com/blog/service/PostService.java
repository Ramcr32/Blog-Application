package com.blog.service;

import java.util.List;

import com.blog.exceptions.PostException;
import com.blog.model.Post;



public interface PostService {
	public List<Post> getAllPost();

	public Post getPostById(Integer id) throws PostException;

	public Post createNewPost(Post post) throws PostException;

	public Post updatePost(Integer id) throws PostException;

	public Post deletePost(Integer id) throws PostException;

}
