package com.cg.cric24.controller;

/**
 * @author Anirban
 * @version 1.0
 *
 * This is the controller class which controls the data flow into model object and
 * updates the view whenever data changes. It keeps view and model separate
 * 
 * */

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.hibernate.query.criteria.internal.expression.ConcatExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;
import com.cg.cric24.service.BlogService;
import com.cg.cric24.service.BlogServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = "/blog")
public class BlogController {
	
	@Autowired
	private BlogService service;
	
	static Logger controllerLogger = Logger.getLogger(BlogController.class);
	
	/**
	 * 
	 *@Access URL- http://localhost:8183/blog/add
	 * 
	 */
	@PostMapping(value = "/add",produces = "application/json",consumes = "application/json")
	public Blog addNewBlog(@Valid @RequestBody Blog blog) {
		controllerLogger.info("To add a new blog");
		return service.addBLog(blog);
	}
	
	/**
	 * 
	 *@Access URL- http://localhost:8183/blog
	 * 
	 */
	@GetMapping(produces = "application/json")
	public List<Blog> findallBlogs(){
		controllerLogger.info("To get the list of all existing blogs");
		return service.listOfBlogs();
	}
	
	/**
	 * 
	 *@Access URL- http://localhost:8183/blog/approve/5
	 * 
	 */
	@PutMapping(value = "/approve/{blogId}",produces = "application/json")
	public int approveBlog(@PathVariable int blogId ) {
		controllerLogger.info("Approve/Reject a particular blog");
		return service.approveBlog(blogId);
	}
	
	/**
	 * 
	 *@Access URL- http://localhost:8183/blog/reject/6
	 * 
	 */
	@PutMapping(value = "/reject/{blogId}",produces = "application/json")
	public int rejectBlog(@PathVariable int blogId ) {
		controllerLogger.info("Approve/Reject a particular blog");
		return service.rejectBlog(blogId);
	}

	/**
	 * 
	 *@Access URL- http://localhost:8183/blog/search/Players
	 * 
	 */
	@GetMapping(value="/search/{blogType}",produces = "application/json")
	public List<Blog> searchByCategory(@PathVariable String blogType) throws BlogNotFoundException{
		controllerLogger.info("Search blog on the basis of type");
		try {
			return service.searchByCategory(blogType);
		} catch (BlogNotFoundException e) {
			e.setUriDetails("uri= /blog/search/" + blogType);
			throw e;
		}
	}
}
