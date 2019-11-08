package com.cg.cric24.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cric24.dto.Blog;

public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	private EntityManager mgr;

	public BlogDaoImpl() {
	}

	@Override
	public Blog addBlog(Blog blog) {

		Blog newBlog = mgr.merge(blog);
		mgr.flush();
		return newBlog;
	}

}
