package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exceptions.CommentException;
import com.blog.model.Comment;
import com.blog.repository.CommentDAO;
@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	private CommentDAO cDao ;
	
	@Override
	public List<Comment> getAllCommentOfPost(Integer postid) throws CommentException {
		List<Comment> comments = cDao.findAllByPostId(postid);
		return comments;
	}

	@Override
	public Comment getCommentById(Integer id) throws CommentException {
		Comment comment = cDao.findById(id).orElseThrow(()->new  CommentException("no comment is fond with id "+id));
		return comment;
	}

	@Override
	public Comment newComment(Integer postid, Comment comment) throws CommentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment updateComment(Integer postid, Comment comment) throws CommentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment deleteComment(Integer id) throws CommentException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
