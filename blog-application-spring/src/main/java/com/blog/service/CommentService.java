package com.blog.service;

import java.util.List;

import com.blog.exceptions.CommentException;
import com.blog.model.Comment;



public interface CommentService {
	public List<Comment> getAllCommentOfPost(Integer postid) throws CommentException;

	public Comment getCommentById(Integer id) throws CommentException;

	public Comment newComment(Integer postId,Comment comment) throws CommentException;

	public Comment updateComment(Integer id, Comment comment) throws CommentException;

	public Comment deleteComment(Integer id) throws CommentException;
}
