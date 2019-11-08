package com.cg.cric24.service;

/**
 * This is the interface of service layer.
 * 
 * @author Anirban
 * @version 1.0
 * 
 * 
 * 
 */

import java.util.List;

import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;

public interface BlogService {
	
	/**
	 * This service is used to add a new blog to the application
	 * @param blog
	 * @return It returns the new blog object with all its properties.
	 */
	Blog addBLog(Blog blog);
	
	/**
	 * This service is used to display all the blogs.
	 * @return it returns the list of all the blogs
	 */
	List<Blog> listOfBlogs();

	/**
	 * This service is used to approve a blog.
	 * @param blogId
	 * @return returns 1 when blog is approved
	 */
	int approveBlog(int blogId);
	
	/**
	 * This service is used to reject a blog.
	 * @param blogId
	 * @return returns 1 when blog is rejected
	 */
	int rejectBlog(int blogId);
	
	/**
	 * This service is used to display a list of blogs on the basis of category.
	 * @param type 
	 * @return it returns blog objects satisfying a condition
	 * @throws BlogNotFoundException
	 */
	List<Blog> searchByCategory(String type) throws BlogNotFoundException;
}
