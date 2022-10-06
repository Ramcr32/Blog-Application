package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.model.Comment;


public interface CommentDAO extends JpaRepository<Comment, Integer> {
	@Query("from Comment as c where c.post.id=:id")
	public List<Comment> findAllByPostId(@Param("id") Integer id);

}
