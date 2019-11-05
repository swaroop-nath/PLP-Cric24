package com.cg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;
import com.cg.cric24.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceApplicationTests {

	@Autowired
	private BlogService service;

	@Test
	public void testAddBLog() {
		Blog newBlog= new Blog();
		newBlog.setBlogType("T20 World");
		newBlog.setBlogHeading("MS");
		newBlog.setBlogContent("Captain");
		
		Blog savedBlog = service.addBLog(newBlog);
		assertEquals(15, savedBlog.getBlogId());
	}
	
	@Test
	public void testListOfBlogs() {
		List<Blog> fetchedBlogs = service.listOfBlogs();
		assertEquals(3, fetchedBlogs.size());
	}
	
	@Test
	public void testApproveBlog() {
		assertEquals(1,service.approveBlog(6));
		
	}
	
	@Test
	public void testRejectBlog() {
		assertEquals(1, service.rejectBlog(13));
	}
	
	
	
	@Test
	public void testSearchByCategory() throws BlogNotFoundException {
		List<Blog> blogs=service.searchByCategory("Players");
		assertNotNull(blogs);
		
	}
	
	@Test(expected = BlogNotFoundException.class)
	public void testSearchByCategoryWithException() throws BlogNotFoundException {
		List<Blog> blogs=service.searchByCategory("Playe");
		
	}
	
	

}
