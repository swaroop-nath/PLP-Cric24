package com.cg.Cric24.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.Cric24.entity.User;
import com.cg.Cric24.exception.UserNotFoundException;
import com.cg.Cric24.exception.WrongPasswordException;
import com.cg.Cric24.exception.WrongSecurityAnswerException;

@RunWith(SpringRunner.class)

@SpringBootTest
public class LoginServiceTest {

	@Autowired
	private LoginService service;
	
	private User user;
	
	/* 
	 * Test case to test if all dependency injection succeeds,
	 * and the application loads successfully.
	 */
	
	@Before
	public void init() {
		user = new User();
		user.setUserId("arvish0609");
		user.setUserName("arvish saluja");
		user.setUserPassword("arvish123");
		user.setUserEmail("arvishsaluja@gmail.com");
		user.setUserPhone("9877598822");
		user.setUserFavFood("hakka noodles");
		user.setUserFavAnimal("cat");
		user.setUserType("blogger");
	}
	
	@Test
	public void testConfirmPassword() throws UserNotFoundException, WrongPasswordException {
		assertTrue(service.confirmPassword("neha3108", "neha123").getUserType().equals("blogger"));
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testFailConfirmPassword() throws UserNotFoundException, WrongPasswordException {
		assertTrue(service.confirmPassword("cfcd", "neha123").getUserType().equals("blogger"));
	}
	
	@Test(expected = WrongPasswordException.class)
	public void testFailConfirmWrongPassword() throws UserNotFoundException, WrongPasswordException {
		assertTrue(service.confirmPassword("neha3108", "cdcdc").getUserType().equals("blogger"));
	}

	@Test
	public void testSignUp() {
		User user1 =service.signUp(user);
		assertTrue(user1.getUserName().equals("arvish saluja"));
	}
	
	@Test
	public void testFailSignUp() {
		User user1 =service.signUp(user);
		assertFalse(user1.getUserName().equals("Pranav"));
	}
	
	@Test
	public void testGetUserById() throws UserNotFoundException {
		assertNotNull(service.getUserById("neha3108"));	
	}

	@Test(expected = UserNotFoundException.class)
	public void testFailGetUserById() throws UserNotFoundException {
		assertNotNull(service.getUserById("njfdncl"));	
	}

	@Test
	public void testDeleteUserByUserId() throws UserNotFoundException {
		assertTrue(service.deleteUserByUserId("arvish0609"));
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testFailDeleteUserByUserId() throws UserNotFoundException {
		assertTrue(service.deleteUserByUserId("bdsclbdc"));
	}

	@Test
	public void testGetAllBloggers() throws UserNotFoundException {
		assertFalse(service.getAllBloggers().isEmpty());	
	}
	
	@Test
	public void testFailGetAllBloggers() throws UserNotFoundException {
		assertNotNull(service.getAllBloggers());	
	}

	@Test
	public void testChangePassword() throws UserNotFoundException, WrongSecurityAnswerException {
		assertTrue(service.changePassword("neha123","neha3108", "maggi" , "cat")>0);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testFailChangePassword() throws UserNotFoundException, WrongSecurityAnswerException {
		assertTrue(service.changePassword("neha123","revr", "maggi" , "cat")>0);
	}
	
	@Test(expected = WrongSecurityAnswerException.class)
	public void testFailChangePasswordWrongSecurity() throws UserNotFoundException, WrongSecurityAnswerException {
		assertTrue(service.changePassword("neha123","neha3108", "csdcdsc" , "cdscsd")>0);
	}
	
	@Test(expected = WrongSecurityAnswerException.class)
	public void testFailChangeWrongPassword() throws UserNotFoundException, WrongSecurityAnswerException {
		assertFalse(service.changePassword("neha123","neha3108", "cwece" , "cacwect")>0);
	}
	
	@Test
	public void testUpdatePassword() throws UserNotFoundException {
		assertTrue(service.updatePassword("neha3108", "neha123", "neha123"));
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testFailUpdatePassword() throws UserNotFoundException {
		assertTrue(service.updatePassword("fedsfcdes", "neha123", "neha123"));
	}

	@Test
	public void testGetByUserName() throws UserNotFoundException {
		assertTrue(service.getByUserName("Neha Bhargava").getUserId().equals("neha3108"));
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testFailGetByUserName() throws UserNotFoundException {
		assertTrue(service.getByUserName("cedc cedc").getUserId().equals("neha3108"));
	}
	
	@Test
	public void testGetByWrongUserName() throws UserNotFoundException {
		assertFalse(service.getByUserName("Neha Bhargava").getUserId().equals("ewedewd"));
	}

}
