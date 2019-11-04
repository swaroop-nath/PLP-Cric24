package com.cg.Cric24.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.Cric24.entity.User;
import com.cg.Cric24.exception.UserNotFoundException;
import com.cg.Cric24.service.LoginService;
import com.cg.Cric24.service.LoginServiceImpl;

public class TestLoginService {
	
	@Autowired
	LoginService service;
	
	@Autowired
	User user;
	
	@Before
	public void init() {
		service = new LoginServiceImpl();
		user = new User();
	}
	
	@Test
	public void testSignUp() {
		user.setUserId("reetu123");
		user.setUserName("reetu rani");
		user.setUserPhone("9855138344");
		user.setUserEmail("reetur@live.com");
		user.setUserPassword("reetu123");
		user.setUserFavFood("wai wai");
		user.setUserFavAnimal("pug");
		user.setUserType("admin");
		
		User user1 = service.signUp(user);
		System.out.println(user1.getUserId());
		assertEquals("reetu123"	, user1.getUserId());
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testGetUserById() {
		try {
			User user = service.getUserById("arvish0609");
			System.out.println(user.getUserName());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(user.getUserName(), "arvish saluja");
		
	}
}
