package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exceptions.PostException;
import com.blog.model.Post;
import com.blog.repository.PostDAO;



@Service
public class PostServiceImp implements PostService {
	@Autowired
	private PostDAO pDao;

	@Override
	public List<Post> getAllPost() {
		List<Post> list = pDao.findAll();
		return list;
	}

	@Override
	public Post getPostById(Integer id) throws PostException {
		Post post = pDao.findById(id).orElseThrow(()->new PostException("no post here with id "+id));
		return post;
	}

	@Override
	public Post createNewPost(Post post) throws PostException {
		return pDao.save(post);
	}

	@Override
	public Post updatePost(Integer id , Post post) throws PostException {
		Post p = pDao.findById(id).orElseThrow(()->new PostException("no post here with id "+id));
		
		return pDao.save(post);
	}

	@Override
	public Post deletePost(Integer id) throws PostException {
		Post post = pDao.findById(id).orElseThrow(()->new PostException("no post here with id "+id));
		
		pDao.delete(post);
		return post;
	}

}
