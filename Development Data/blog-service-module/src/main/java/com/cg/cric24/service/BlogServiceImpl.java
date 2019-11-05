package com.cg.cric24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.dao.BlogDao;
import com.cg.cric24.dto.Blog;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	private BlogDao dao;

	@Override
	public Blog addBlog(Blog blog) {
		return dao.save(blog);
	}

	

	@Override
	public int rejectBlog(int blogId) {
		return dao.rejectBlog(blogId);
	}

	@Override
	public int approveBlog(int blogId) {
		return dao.approveBlog(blogId);  
	}



	@Override
	public List<Blog> approvedBlogs() {
		return dao.approvedBlogs();
	}

}
