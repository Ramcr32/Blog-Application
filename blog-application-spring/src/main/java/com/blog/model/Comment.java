package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Comment {
	@Id
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String body;
	@ManyToOne(fetch =  FetchType.LAZY)
	private Post post;
}
