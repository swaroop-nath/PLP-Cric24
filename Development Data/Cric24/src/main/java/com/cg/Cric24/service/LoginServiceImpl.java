package com.cg.Cric24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.Cric24.dao.LoginDao;
import com.cg.Cric24.entity.User;
import com.cg.Cric24.exception.UserNotFoundException;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDao dao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User signUp(User user) {
		System.out.println(passwordEncoder);
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		return dao.save(user);
	}

	@Override
	public User getUserById(String userId) throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			throw new UserNotFoundException("No user exists with id :" + userId);
		}
		return user;
	}

	@Override
	public boolean deleteUserByUserId(String userId) throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			throw new UserNotFoundException("No user exists with Id:" + userId);
		}
		dao.deleteById(userId);
		return true;

	}

	@Override
	public List<User> getAllBloggers() throws UserNotFoundException {
		List<User> users = dao.getAllBloggers("blogger");
		if (users.isEmpty())
			throw new UserNotFoundException("No bloggers exits at the point");
		else
			return users;
	}

	@Override
	public int changePassword(String password, String userId, String favFood, String favAnimal)
			throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			throw new UserNotFoundException("no user exists with id : " + userId);
		}
		if (user.getUserFavFood().equals(favFood) || user.getUserFavAnimal().equals(favAnimal)) {
			password = passwordEncoder.encode(password);
			int x = dao.changePassword(password, userId);
			return x;
		} else
			return 0;

	}

	@Override
	public String encryptPassword(String userId, String userPassword) throws UserNotFoundException {
		User user = dao.findById(userId).get();
		if (user == null)
			throw new UserNotFoundException("No user exists with id :" + userId);
		else
			return passwordEncoder.encode(userPassword);

	}

	@Override
	public boolean updatePassword(String userId, String oldPassword, String newPassword) throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			throw new UserNotFoundException("No user exists with id :" + userId);
		}
		
		if (passwordEncoder.matches(oldPassword, user.getUserPassword())) {
			user.setUserPassword(passwordEncoder.encode(newPassword));
			dao.save(user);
			return true;
		} else
			return false;
	}

	@Override
	public User getByUserName(String userName) throws UserNotFoundException {
		User user = dao.getByUserName(userName);
		if (user == null)
			throw new UserNotFoundException("no blogger exists with user name :" + userName);
		else
			return user;
	}

	@Override
	public boolean confirmPassword(String userId, String userPassword) throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			throw new UserNotFoundException("No user exists with id :" + userId);
		}
		if (passwordEncoder.matches(userPassword,user.getUserPassword()))
			return true;
		else
			return false;
	}

}
