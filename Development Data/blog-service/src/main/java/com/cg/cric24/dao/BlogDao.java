package com.cg.cric24.dao;

import java.util.List;


import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;

public interface BlogDao {

	Blog addBlog(Blog blog);
	
	/**
	 * Custom query for displaying all blogs
	 * @return It will return list of blogs
	 */
	public List<Blog> allBlogs();
	
	/**
	 * Custom query to approve a blog
	 * @param blgId
	 * @return returns 1 when blog is approved
	 */
	public int approveBlog(int blgId);

	/**
	 * Custom query to reject a blog
	 * @param blgId
	 * @return returns 1 when blog is rejected
	 */
	public int rejectBlog(int blgId);
	
	
	/**
	 * Custom query to display a list of blogs of a particular type
	 * @param type
	 * @return returns a list of blogs object based on the query
	 * @throws BlogNotFoundException 
	 */
	public List<Blog> searchByCategory(String type) throws BlogNotFoundException;
}
