package com.cg.cric24.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.dao.BlogDao;
import com.cg.cric24.dao.BlogRepo;
import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;


@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	
	static Logger serviceLogger = Logger.getLogger(BlogServiceImpl.class.getName());
	
	@Autowired
	private BlogRepo repo;
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
		return repo.allBlogs();
	}

	@Override
	public int approveBlog(int blogId) {
		serviceLogger.info("Blog yet to be approved/rejected");
		return repo.approveBlog(blogId);
	}

	@Override
	public int rejectBlog(int blogId) {
		serviceLogger.info("Blog yet to be approved/rejected");
		return repo.rejectBlog(blogId);
	}

	@Override
	public List<Blog> searchByCategory(String type) throws BlogNotFoundException {
		List<Blog> blogs;
		try {
			blogs = repo.searchByCategory(type);
			if(blogs.size() == 0) {
				serviceLogger.error("Invalid blog type");
				throw new BlogNotFoundException("Invalid Blog type entered");
			}
			else {
				serviceLogger.info("search successful");
				return blogs;
			}
		} catch (Exception e) {
			throw new BlogNotFoundException("Invalid Blog type entered");
		}
	}
}