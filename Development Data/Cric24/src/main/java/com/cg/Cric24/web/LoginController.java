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
	public User addUser(@RequestBody User user) {
		controllerLogger.info("new user sign up");
		return service.signUp(user);
	}

	/*
	 * Access URL - "http://localhost:9898/login/admin/delete/arvish0609"
	 */
	@DeleteMapping("/admin/delete/{userId}")
	public String deleteUserByUserId(@PathVariable String userId) throws UserNotFoundException {
		try {
			service.deleteUserByUserId(userId);
		} catch (UserNotFoundException e) {
			e.setUriDetails("uri=/user/id" +userId);
		}
		controllerLogger.info("delete user with given ID");
		return "User deleted with Id:" + userId;
	}

	/*
	 * Access URL -
	 * "http://localhost:9898/login/forgetPassword/arvish/arvish0609/hakka noodles/elephant"
	 */
	@PutMapping("/forgetPassword/{password}/{userId}/{favFood}/{favAnimal}")
	public boolean forgetPassword(@PathVariable String password, @PathVariable String userId,
			@PathVariable String favFood, @PathVariable String favAnimal) throws UserNotFoundException {
		if (service.changePassword(password, userId, favFood, favAnimal) == 1) {
			controllerLogger.info("change password if forgot");
			return true;
		} else
			return false;

	}

	/*
	 * Access URL - "http://localhost:9898/login/bloggers"
	 */
	@GetMapping("/bloggers")
	public List<User> getAllBloggers() throws UserNotFoundException {
		List<User> users = service.getAllBloggers();
		controllerLogger.info("list of all bloggers");
		return users;
	}

	/*
	 * Access URL - "http://localhost:9898/login/enter/arvish0609/hesoyam"
	 */
	@GetMapping(value = "/enter/{userId}/{userPassword}", produces = "application/json")
	public User loginCredentials(@PathVariable String userId, @PathVariable String userPassword)
			throws UserNotFoundException {
		return service.confirmPassword(userId, userPassword);

	}

	/*
	 * Access URL - "http://localhost:9898/login/updatePassword/hesoyam/arvish123"
	 */
	@GetMapping("/updatePassword/{userId}/{oldPassword}/{newPassword}")
	public boolean updatePassword(@PathVariable String userId, @PathVariable String oldPassword,
			@PathVariable String newPassword) throws UserNotFoundException {
		if (service.updatePassword(userId, oldPassword, newPassword)) {
			controllerLogger.info("update old password");
			return true;
		} else
			return false;
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
			e.setUriDetails("uri= /user/name/" + userName);
			throw e;
		}
	}

}
