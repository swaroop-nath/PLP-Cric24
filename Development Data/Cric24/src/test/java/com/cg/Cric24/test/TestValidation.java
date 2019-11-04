package com.cg.Cric24.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.Cric24.service.LoginService;

public class TestValidation {
	
	@Autowired
	LoginService service;
	
	@Test
	public void testValidatUserId() {
		boolean validUserId = LoginService.validateUserId("1234");
		assertEquals(true,validUserId);
	}
	
	@Test
	public void testValidateUserPhone() {
		String phone = "9877598822";
		boolean validPhone = LoginService.validateUserPhone(phone);
		assertEquals(true, validPhone);
	}
	
	@Test
	public void testValidUserEmail() {
		String email= "arvishsaluja@gmail.com";
		boolean validEmail = LoginService.validateUserEmail(email);
		assertEquals(true, validEmail);
	}
	
	@Test
	public void testValidPassword() {
		String password = "Arvish@0609";
		boolean validPassword = LoginService.validatePassword(password);
		assertEquals(true, validPassword);
	}
	
	@Test
	public void testValidUserName() {
		String userName = "Arvish Saluja";
		boolean validUserName = LoginService.validateUserName(userName);
		assertEquals(true,validUserName);
	}
	
//	@Test
//	public void testValidUserFavAnimal() {
//		String animal = "Cat";
//		boolean validAnimal = LoginService.validateUserFavAnimal(animal);
//		assertEquals(false, validAnimal);
//	}
//	
//	@Test
//	public void testValidUserfavFood() {
//		String food = "Noodles";
//		boolean validFood = LoginService.validateUserFavFood(food);
//		assertEquals(false, validFood);
//	}
	
	

}
