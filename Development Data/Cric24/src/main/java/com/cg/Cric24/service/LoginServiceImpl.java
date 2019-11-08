package com.cg.Cric24.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.Cric24.entity.User;
import com.cg.Cric24.exception.UserNotFoundException;
import com.cg.Cric24.repo.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao dao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	static Logger serviceLogger = Logger.getLogger(LoginServiceImpl.class);

	@Override
	public User signUp(User user) {
		System.out.println(passwordEncoder);
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		serviceLogger.info("New user signing up");
		return dao.save(user);
	}

	@Override
	public User getUserById(String userId) throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			serviceLogger.error("user with given ID not present");
			throw new UserNotFoundException("No user exists with id :" + userId);
		}
		serviceLogger.info("user with given user-id found");
		return user;
	}

	@Override
	public boolean deleteUserByUserId(String userId) throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			serviceLogger.error("user with given ID not present");
			throw new UserNotFoundException("No user exists with Id:" + userId);
		}
		dao.deleteById(userId);
		serviceLogger.info("user with given user-id deleted");
		return true;

	}

	@Override
	public List<User> getAllBloggers() throws UserNotFoundException {
		List<User> users = dao.getAllBloggers("blogger");
		if (users.isEmpty()) {
			serviceLogger.error("no bloggers present");
			throw new UserNotFoundException("No bloggers exits at the point");
		}
		else {
			serviceLogger.info("list of all bloggers returned");
			return users;
		}
	}

	@Override
	public int changePassword(String password, String userId, String favFood, String favAnimal)
			throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			serviceLogger.error("no user with this ID present");
			throw new UserNotFoundException("no user exists with id : " + userId);
		}
		if (user.getUserFavFood().equals(favFood) || user.getUserFavAnimal().equals(favAnimal)) {
			password = passwordEncoder.encode(password);
			int x = dao.changePassword(password, userId);
			serviceLogger.info("send back the new encoded password with a user-ID");
			return x;
		} else
			return 0;

	}

	@Override
	public String encryptPassword(String userId, String userPassword) throws UserNotFoundException {
		User user = dao.findById(userId).get();
		if (user == null) {
			serviceLogger.error("user with given id and password not found");
			throw new UserNotFoundException("No user exists with id :" + userId);
		}
		else {
			serviceLogger.info("send the new encrypted password");
			return passwordEncoder.encode(userPassword);
		}

	}

	@Override
	public boolean updatePassword(String userId, String oldPassword, String newPassword) throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		} catch (Exception exception) {
			serviceLogger.error("user with given id and password not found");
			throw new UserNotFoundException("No user exists with id :" + userId);
		}
		
		if (passwordEncoder.matches(oldPassword, user.getUserPassword())) {
			user.setUserPassword(passwordEncoder.encode(newPassword));
			dao.save(user);
			serviceLogger.info("updated and encrypted password sent");
			return true;
		} else
			return false;
	}

	@Override
	public User getByUserName(String userName) throws UserNotFoundException {
		User user = dao.getByUserName(userName);
		if (user == null) {
			serviceLogger.error("no user with this user name present");
			throw new UserNotFoundException("no blogger exists with user name :" + userName);
		}
		else {
			serviceLogger.info("user found");
			return user;
		}
	}

	@Override
	public User confirmPassword(String userId, String userPassword) throws UserNotFoundException {
		User user;
		try {
			user = dao.findById(userId).get();
		
		if (passwordEncoder.matches(userPassword,user.getUserPassword())) {
			serviceLogger.info("password confirmed");
			return user;
		}
		
		} catch (Exception exception) {
			serviceLogger.error("no user with this ID present");
			throw new UserNotFoundException("No user exists with id :" + userId);
		}
		
		return null;
		
	}

}
