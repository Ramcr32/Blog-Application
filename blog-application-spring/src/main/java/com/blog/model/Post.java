package com.blog.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Length(min = 2 ,message = "length should be 2")
	private String title;
	@NotNull
	@Length(min = 10 ,message = "length should be 10")
	private String description;
	@NotNull
	private String content;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Comment> comment = new ArrayList<>();
}
