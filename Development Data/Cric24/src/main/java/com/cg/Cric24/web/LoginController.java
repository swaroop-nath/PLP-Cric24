package com.cg.Cric24.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PutMapping("/forgetPassword")
	public String forgetPassword(@RequestParam String password, @RequestParam String userId,
			@RequestParam String favFood, @RequestParam String favAnimal) throws UserNotFoundException {
		if (service.changePassword(password, userId, favFood, favAnimal) == 1)
			return "Password updated";
		else
			return "Security Questions answered wrong";

	}

	@GetMapping("/bloggers")
	public List<User> getAllBloggers() throws UserNotFoundException {
		List<User> users = service.getAllBloggers();
		return users;
	}

	@GetMapping("/enter")
	public String loginCredentials(@RequestParam String userId, @RequestParam String userPassword)
			throws UserNotFoundException {
		if (service.confirmPassword(userId, userPassword))
			return "Login successfull";
		return "kidnly enter the right password";
	}

	@GetMapping("/updatePassword")
	public String updatePassword(@RequestParam String userId, @RequestParam String oldPassword,
			@RequestParam String newPassword) throws UserNotFoundException {
		if (service.updatePassword(userId, oldPassword, newPassword))
			return "Password updated successfully";
		else
			return "wrong password";
	}

	@GetMapping("/getBlogger/{userName}")
	public User getBlogger(@PathVariable String userName) throws UserNotFoundException {
		return service.getByUserName(userName);
	}

}
