package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exceptions.CommentException;
import com.blog.exceptions.PostException;
import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.repository.CommentDAO;
import com.blog.repository.PostDAO;
@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	private CommentDAO cDao ;
	
	@Autowired 
	private PostDAO pDao;
	
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
	public Comment newComment(Integer postId,Comment comment) throws CommentException {
		Post post  = pDao.findById(postId).orElseThrow(()->new PostException("post is not found with id "+postId));
//		System.out.println(post.getComment().isEmpty());
//		post.getComment().add(comment);
//		pDao.save(post);
		return cDao.save(comment);
	}

	@Override
	public Comment updateComment(Integer id, Comment comment) throws CommentException {
		Comment c = cDao.findById(id).orElseThrow(()->new  CommentException("no comment is fond with id "+id));
		cDao.save(comment);
		return comment;
		
	}

	@Override
	public Comment deleteComment(Integer id) throws CommentException {
		Comment c = cDao.findById(id).orElseThrow(()->new  CommentException("no comment is fond with id "+id));
		cDao.delete(c);
		return c;
	}
	

}
