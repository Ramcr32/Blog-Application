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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post createNewPost(Post post) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePost(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post deletePost(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

}
