package com.cg.Cric24.web;

/**
 * This is the controller class which controls the data flow into model object and
 * updates the view whenever data changes. It keeps view and model separate
 * 
 * @author Arvish
 * @version 1.0
 * 
 * */
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Cric24.entity.User;
import com.cg.Cric24.exception.UserNotFoundException;
import com.cg.Cric24.exception.WrongPasswordException;
import com.cg.Cric24.exception.WrongSecurityAnswerException;
import com.cg.Cric24.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService service;

	static Logger controllerLogger = Logger.getLogger(LoginController.class);

	/*
	 * Access URL - "http://localhost:9898/login/add"
	 */
	@PostMapping("/add")
	public User addUser( @Valid @RequestBody User user) {
		controllerLogger.info("new user sign up");
		return service.signUp(user);
	}

	/*
	 * Access URL - "http://localhost:9898/login/admin/delete/arvish0609"
	 */
	@DeleteMapping("/admin/delete/{userId}")
	public boolean deleteUserByUserId(@PathVariable String userId) throws UserNotFoundException {
		try {
			controllerLogger.info("delete user with given ID");
			return service.deleteUserByUserId(userId);
		} catch (UserNotFoundException e) {
			e.setUriDetails("uri=/login/admin/delete/" + userId);
			throw e;
		}

	}

	/*
	 * Access URL -
	 * "http://localhost:9898/login/forgetPassword/arvish/arvish0609/hakka noodles/elephant"
	 */
	@PutMapping("/forgetPassword/{password}/{userId}/{favFood}/{favAnimal}")
	public int forgetPassword(@PathVariable String password, @PathVariable String userId, @PathVariable String favFood,
			@PathVariable String favAnimal) throws UserNotFoundException, WrongSecurityAnswerException {
		try {
			controllerLogger.info("change password if forgot");
			return service.changePassword(password, userId, favFood, favAnimal);
		} catch (UserNotFoundException e) {
			e.setUriDetails("uri=/login/forgetPassword/" + password+"/"+ userId +"/"+ favFood+ "/" + favAnimal);
			throw e;
		}catch (WrongSecurityAnswerException e1) {
			e1.setUriDetails("uri=/login/forgetPassword/" + password+"/"+ userId +"/"+ favFood+ "/" + favAnimal);
			throw e1;
		}

	}

	/*
	 * Access URL - "http://localhost:9898/login/bloggers"
	 */
	@GetMapping("/bloggers")
	public List<User> getAllBloggers() throws UserNotFoundException {
		controllerLogger.info("list of all bloggers");
		try {
			return service.getAllBloggers();
		} catch (UserNotFoundException e) {
			e.setUriDetails("uri=/login/bloggers");
			throw e;
		}
	}

	/*
	 * Access URL - "http://localhost:9898/login/enter/arvish0609/hesoyam"
	 */
	@GetMapping(value = "/enter/{userId}/{userPassword}", produces = "application/json")
	public User loginCredentials(@PathVariable String userId, @PathVariable String userPassword)
			throws UserNotFoundException, WrongPasswordException {
		try {
			return service.confirmPassword(userId, userPassword);
		} catch (UserNotFoundException e) {
			e.setUriDetails("uri=/login/enter/"+ userId +"/"+ userPassword);
			throw e;
		}catch (WrongPasswordException e1) {
			e1.setUriDetails("uri=/login/enter/"+ userId +"/"+ userPassword);
			throw e1;
		}

	}

	/*
	 * Access URL - "http://localhost:9898/login/updatePassword/hesoyam/arvish123"
	 */
	@GetMapping("/updatePassword/{userId}/{oldPassword}/{newPassword}")
	public boolean updatePassword(@PathVariable String userId, @PathVariable String oldPassword,
			@PathVariable String newPassword) throws UserNotFoundException {
		try {
			controllerLogger.info("update old password");
			return service.updatePassword(userId, oldPassword, newPassword);
		} catch (UserNotFoundException e) {
			e.setUriDetails("uri=/login/updatePassword/" + userId +"/" +oldPassword + "/" + newPassword);
			throw e;
		}	
	}

	/*
	 * Access URL - "http://localhost:9898/login/getBlogger/arvish saluja"
	 */
	@GetMapping("/getBlogger/{userName}")
	public User getBlogger(@PathVariable String userName) throws UserNotFoundException {
		controllerLogger.info("get a blogger with user-name entered");
		try {
			return service.getByUserName(userName);
		} catch (UserNotFoundException e) {
			e.setUriDetails("uri= /login/getBloger/" + userName);
			throw e;
		}
	}

}
