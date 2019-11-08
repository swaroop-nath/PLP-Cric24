package com.cg.Cric24.service;

/**
 * This is the interface of service layer
 * @author Arvish
 *
 */
import java.util.List;

import com.cg.Cric24.entity.User;
import com.cg.Cric24.exception.UserNotFoundException;


public interface LoginService {

	/**
	 * This service is used to confirm entered userId and password. 
	 * @param userId
	 * @param userPassword
	 * @return returns true if password is confirmed else throws exception
	 * @throws UserNotFoundException
	 */
	User confirmPassword(String userId, String userPassword) throws UserNotFoundException;

	/**
	 * This service is called when a new user wants to create an account
	 * @param user
	 * @return created account details of new user
	 */
	User signUp(User user);
	
	/**
	 * This service returns a  user based on his user-ID
	 * @param userId
	 * @return returns a user if present else throw exception
	 * @throws UserNotFoundException
	 */
	User getUserById(String userId) throws UserNotFoundException;
	
	/**
	 * This service deletes an already existing user based on user-ID.
	 * @param userId
	 * @return true if Id found and deleted else display exception message
	 * @throws UserNotFoundException
	 */
	boolean deleteUserByUserId(String userId) throws UserNotFoundException;
	
	/**
	 * This service returns list of the bloggers present for the application
	 * @return all bloggers
	 * @throws UserNotFoundException
	 */
	List<User> getAllBloggers() throws UserNotFoundException;
	
	/**
	 * This service method is called if a user/admin forgets his password.
	 * @param password
	 * @param userId
	 * @param favFood
	 * @param favAnimal
	 * @return integer value if password change is successful
	 * @throws UserNotFoundException
	 */
	int changePassword(String password, String userId, String favFood, String favAnimal) throws UserNotFoundException;
	
	/**
	 * This service is called to encrypt the entered password and then store into the database. 
	 * This is done for security purposes.
	 * @param userId
	 * @param userPassword
	 * @return an encrypted password
	 * @throws UserNotFoundException
	 */
	String encryptPassword(String userId, String userPassword) throws UserNotFoundException;
	
	/**
	 * This service method is called if a user/admin wants to change his password
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return true if password change is successful
	 * @throws UserNotFoundException
	 */
	boolean updatePassword(String userId, String oldPassword, String newPassword) throws UserNotFoundException;
	
	/**
	 * This service fetches a user based on his user-name
	 * @param userName
	 * @return details of user based on user-name if present else display exception
	 * @throws UserNotFoundException
	 */
	User getByUserName(String userName) throws UserNotFoundException;
}
