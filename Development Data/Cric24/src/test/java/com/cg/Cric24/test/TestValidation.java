package com.cg.Cric24.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.Cric24.service.LoginService;

public class TestValidation {
	
	@Autowired
	LoginService service;
	
	@Test
	public void testValidatUserId() {
		assertTrue(LoginService.validateUserId("arvish0609"));
	}
	
	@Test
	public void testValidateUserPhone() {
		assertTrue(LoginService.validateUserPhone("9877598822"));
	}
	
	@Test
	public void testValidUserEmail() {
		assertTrue(LoginService.validateUserEmail("arvishsaluja@gmail.com"));
	}
	
	@Test
	public void testValidPassword() {
		assertTrue(LoginService.validatePassword("Arvish1@23"));
	}
	
	@Test
	public void testValidUserName() {
		assertTrue(LoginService.validateUserName("Arvish Saluja"));
	}
	
	@Test
	public void testValidUserFavAnimal() {
		assertTrue(LoginService.validateUserFavAnimal("bxjhk"));
	}
	
	@Test
	public void testValidUserfavFood() {
		assertTrue(LoginService.validateUserFavFood("bxjhk"));
	}
	
	

}
