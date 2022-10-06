package com.blog.service;

import java.util.List;

import com.blog.exceptions.CommentException;
import com.blog.model.Comment;



public interface CommentService {
	public List<Comment> getAllCommentOfPost(Integer postid) throws CommentException;

	public Comment getCommentById(Integer postid) throws CommentException;

	public Comment newComment(Integer postid ,Comment comment) throws CommentException;

	public Comment updateComment(Integer postid, Comment comment) throws CommentException;

	public Comment deleteComment(Integer id) throws CommentException;
}
