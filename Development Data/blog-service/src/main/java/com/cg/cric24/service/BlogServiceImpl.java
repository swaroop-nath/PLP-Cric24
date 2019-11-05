package com.cg.cric24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.dao.BlogDao;
import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;


@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao dao;

	@Override
	public Blog addBLog(Blog blog) {
		blog.setStatus("Unapproved");
		return dao.save(blog);
	}

	@Override
	public List<Blog> listOfBlogs() {
		return dao.approvedBlogs();
	}

	@Override
	public int approveBlog(int blogId) {
		return dao.approveBlog(blogId);
	}

	@Override
	public int rejectBlog(int blogId) {
		return dao.rejectBlog(blogId);
	}

	@Override
	public List<Blog> searchByCategory(String type) throws BlogNotFoundException {
		List<Blog> blogs;
		try {
			blogs = dao.searchByCategory(type);
			if(blogs.size() == 0)
				throw new BlogNotFoundException("Invalid Blog type entered");
			else
				return blogs;
		} catch (Exception e) {
			throw new BlogNotFoundException("Invalid Blog type entered");
		}
	}
}