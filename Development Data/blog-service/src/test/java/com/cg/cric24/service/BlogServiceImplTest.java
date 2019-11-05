/**
 * 
 */
package com.cg.cric24.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cric24.controller.BlogController;
import com.cg.cric24.dto.Blog;

/**
 * @author admin
 *
 */
@SpringBootTest
public class BlogServiceImplTest {

	@Autowired
	private BlogController controller;
	@Autowired
	private BlogService service;

	/**
	 * Test method for {@link com.cg.cric24.service.BlogServiceImpl#addBLog(com.cg.cric24.dto.Blog)}.
	 */
	@Test
	public void testAddBLog() {
		Blog newBlog= new Blog();
		newBlog.setBlogType("Abc");
		newBlog.setBlogHeading("Ganguly");
		newBlog.setBlogContent("BCCI President");
		
		Blog savedBlog = service.addBLog(newBlog);
		assertEquals(6, savedBlog.getBlogId());
	}

	/**
	 * Test method for {@link com.cg.cric24.service.BlogServiceImpl#listOfBlogs()}.
	 */
	@Test
	public void testListOfBlogs() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cg.cric24.service.BlogServiceImpl#approveBlog(int)}.
	 */
	@Test
	public void testApproveBlog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cg.cric24.service.BlogServiceImpl#rejectBlog(int)}.
	 */
	@Test
	public void testRejectBlog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cg.cric24.service.BlogServiceImpl#searchByCategory(java.lang.String)}.
	 */
	@Test
	public void testSearchByCategory() {
		fail("Not yet implemented");
	}

}
