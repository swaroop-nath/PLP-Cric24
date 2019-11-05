package com.cg.cric24.service;

import java.util.List;

import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;

public interface BlogService {
	
	Blog addBLog(Blog blog);
	
	List<Blog> listOfBlogs();

	int approveBlog(int blogId);
	
	int rejectBlog(int blogId);
	
	List<Blog> searchByCategory(String type) throws BlogNotFoundException;
}
