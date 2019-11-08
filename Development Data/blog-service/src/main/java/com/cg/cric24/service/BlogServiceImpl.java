package com.cg.cric24.service;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.dao.BlogDao;
import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;


@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	
	static Logger serviceLogger = Logger.getLogger(BlogServiceImpl.class.getName());
	
	@Autowired
	private BlogDao dao;

	@Override
	public Blog addBLog(Blog blog) {
		blog.setStatus("Unapproved");
		serviceLogger.info("Blog to be added");
		return dao.addBlog(blog);
	}

	@Override  
	public List<Blog> listOfBlogs() {
		serviceLogger.info("List of all blogs added");
		return dao.allBlogs();
	}

	@Override
	public int approveBlog(int blogId) {
		serviceLogger.info("Blog yet to be approved/rejected");
		return dao.approveBlog(blogId);
	}

	@Override
	public int rejectBlog(int blogId) {
		serviceLogger.info("Blog yet to be approved/rejected");
		return dao.rejectBlog(blogId);
	}

	@Override
	public List<Blog> searchByCategory(String type) throws BlogNotFoundException {
		serviceLogger.info("Search by category successful");
		return dao.searchByCategory(type);
	}
}