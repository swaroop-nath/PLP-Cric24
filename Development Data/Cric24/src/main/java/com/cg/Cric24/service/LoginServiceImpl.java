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
		User user = dao.findById(userId).get();
		if(user == null)
			throw new UserNotFoundException("No user exists with id :"+ userId);
		else
			return user;
	}

	@Override
	public boolean deleteUserByUserId(String userId) throws UserNotFoundException {
		User user = dao.findById(userId).get();
		if (user == null)
			throw new UserNotFoundException("No user exists with Id:" + userId);
		dao.deleteById(userId);
		return true;

	}

	@Override
	public List<User> getAllBloggers(String userType) throws UserNotFoundException {
		List<User> users= dao.getAllBloggers(userType);
		if(users.isEmpty())
			throw new UserNotFoundException("No bloggers exits at the point");
		else
			return users;
	}

	@Override
	public int changePassword(String password, String userId) throws UserNotFoundException {
		password = passwordEncoder.encode(password);
		int x = dao.changePassword(password, userId);
		if(x == 0)
			throw new UserNotFoundException("no user exists with id : "+ userId);
		else 
			return x;
	}

	@Override
	public String encryptPassword(String userId, String userPassword) throws UserNotFoundException {
		User user = dao.findById(userId).get();
		if(user == null)
			throw new UserNotFoundException("No user exists with id :" + userId);
		else
		return passwordEncoder.encode(userPassword);

	}

	@Override
	public boolean updatePassword(String userId, String oldPassword, String newPassword) throws UserNotFoundException {
		User user = dao.findById(userId).get();
		if(user == null)
			throw new UserNotFoundException("No user exists with Id : " + userId);
		if (passwordEncoder.matches(oldPassword, user.getUserPassword())) {
			user.setUserPassword(passwordEncoder.encode(newPassword));
			dao.save(user);
			return true;
		}
		else
			return false;
	}

	@Override
	public User getByUserName(String userName) throws UserNotFoundException {
		User user=  dao.getByUserName(userName);
		if(user == null)
			throw new UserNotFoundException("no user exists with user name :" + userName);
		else 
			return user;
	}

}
