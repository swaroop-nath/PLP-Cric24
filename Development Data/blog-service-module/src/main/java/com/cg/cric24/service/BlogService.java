package com.cg.cric24.service;

import java.util.List;

import com.cg.cric24.dto.Blog;

public interface BlogService {
	
	Blog addBlog(Blog blog); 
	
	public List<Blog> approvedBlogs();
	
	int rejectBlog(int creatorId);
	
	int approveBlog(int creatorId);

}
