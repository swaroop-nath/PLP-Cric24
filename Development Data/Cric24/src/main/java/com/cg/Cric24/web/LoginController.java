package com.cg.Cric24.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return service.signUp(user);
	}

	@DeleteMapping("/admin/delete/{userId}")
	public String deleteUserByUserId(@PathVariable String userId) throws UserNotFoundException {
		service.deleteUserByUserId(userId);
		return "User deleted with Id:" + userId;
	}

	@PutMapping("/forgetPassword/{password}/{userId}/{favFood}/{favAnimal}")
	public boolean forgetPassword(@PathVariable String password, @PathVariable String userId,
			@PathVariable String favFood, @PathVariable String favAnimal) throws UserNotFoundException {
		if (service.changePassword(password, userId, favFood, favAnimal) == 1)
			return true;
		else
			return false;

	}

	@GetMapping("/bloggers")
	public List<User> getAllBloggers() throws UserNotFoundException {
		List<User> users = service.getAllBloggers();
		return users;
	}

	@GetMapping(value = "/enter/{userId}/{userPassword}", produces = "application/json")
	public String loginCredentials(@PathVariable String userId, @PathVariable String userPassword)
			throws UserNotFoundException {
		if (service.confirmPassword(userId, userPassword)) {
			String s = service.getUserById(userId).getUserType();
			return s ;
		}
		else
			return null;
	}

	@GetMapping("/updatePassword/{userId}/{oldPassword}/{newPassword}")
	public boolean updatePassword(@PathVariable String userId, @PathVariable String oldPassword,
			@PathVariable String newPassword) throws UserNotFoundException {
		if (service.updatePassword(userId, oldPassword, newPassword))
			return true;
		else
			return false;
	}

	@GetMapping("/getBlogger/{userName}")
	public User getBlogger(@PathVariable String userName) throws UserNotFoundException {
		return service.getByUserName(userName);
	}

}
