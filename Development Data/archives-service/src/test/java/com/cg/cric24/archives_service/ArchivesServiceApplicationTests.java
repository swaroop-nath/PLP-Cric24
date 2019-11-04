package com.cg.cric24.archives_service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cric24.archives_service.controller.ArchivesServiceController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchivesServiceApplicationTests {
	
	@Autowired ArchivesServiceController controller;

	/* 
	 * Test case to test if all dependency injection succeeds,
	 * and the application loads successfully.
	 */
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}

}
