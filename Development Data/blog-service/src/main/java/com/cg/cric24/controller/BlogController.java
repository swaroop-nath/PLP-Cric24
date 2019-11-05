package com.cg.cric24.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/blog")
public class BlogController {
	
	@Autowired
	private BlogService service;
	
	@PostMapping(value = "/add",produces = "application/json",consumes = "application/json")
	public Blog addNewBlog(@RequestBody Blog blog) {
		return service.addBLog(blog);
	}
	
	@GetMapping(produces = "application/json")
	public List<Blog> findallBlogs(){
		return service.listOfBlogs();
	}
	
	@PutMapping(value = "/approve/{blogId}",produces = "application/json",consumes = "application/json")
	public int approveBlog(@PathVariable int blogId ) {
		return service.approveBlog(blogId);
	}
	
	@PutMapping(value = "/reject/{blogId}",produces = "application/json",consumes = "application/json")
	public int rejectBlog(@PathVariable int blogId ) {
		return service.rejectBlog(blogId);
	}

	@GetMapping(value="/search/{blogType}",produces = "application/json")
	public List<Blog> searchByCategory(@PathVariable String blogType) throws BlogNotFoundException{
		return service.searchByCategory(blogType);
	}
}
