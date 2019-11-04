package com.cg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cric24.controller.BlogController;
import com.cg.cric24.dto.Blog;
import com.cg.cric24.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceModuleApplicationTests {
	
	@Autowired private BlogController controller;
	@Autowired private BlogService service;

	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}

	@Test
	public void testAddBlog() {
		Blog newBlog = new Blog();
		//set
		Blog addedBlog = service.addBlog(newBlog);
		assertNotNull(addedBlog);
		
		assertEquals(3, addedBlog.getBlogID());
	}
	
	@Test(expected = NoBlogFoundException.class)
}
