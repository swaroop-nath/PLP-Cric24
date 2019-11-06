package com.cg.Cric24.service;

import java.util.List;

import com.cg.Cric24.entity.User;
import com.cg.Cric24.exception.UserNotFoundException;


public interface LoginService {
	// Regex to validate name- Must contain only letters, white spaces are allowed , also should start with capital latter
	String USER_NAME_VALIDATOR = "[A-Z][A-Za-z ]+";
	// Regex to validate phone number - Must contain 10 digits and the number should start from either 6,7,8 or 9. 
	String USER_PHONE_VALIDATOR = "[6-9][0-9]{9}";
	// Regex to validate email- Must contain only one @ and .
	String USER_EMAIL_VALIDATOR = "[\\w_]+@[a-z]{3,20}.[a-z]{2,4}";
	// Regex to validate user favorite food - Must be a word with more than 2 alphabets
	String USER_FAV_FOOD_VALIDATOR = "[A-Za-z ]+";
	// Regex to validate user favorite animal - Must be a word with more than 2 alphabets
	String USER_FAV_ANIMAL_VALIDATOR = "[A-Za-z ]+";
	// Regex to validate user Id - Must be a combination of words and numbers
	String USER_ID_VALIDATOR = "[A-Za-z0-9]+";
	// Regex to validate password - Must contain atleast one caps, one number and one special character (@, #, $, %).
	String USER_PASSWORD_VALIDATOR="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	static boolean validateUserId(String userId) {
		return userId.matches(USER_ID_VALIDATOR);
	}

	static boolean validateUserPhone(String userPhone) {
		return userPhone.matches(USER_PHONE_VALIDATOR);
	}

	static boolean validateUserEmail(String userEmail) {
		return userEmail.matches(USER_EMAIL_VALIDATOR);
	}

	static boolean validateUserName(String userName) {
		return userName.matches(USER_NAME_VALIDATOR);
	}

	static boolean validateUserFavFood(String userFavFood) {
		return userFavFood.matches(USER_FAV_FOOD_VALIDATOR);

	}

	static boolean validateUserFavAnimal(String userFavAnimal) {
		return userFavAnimal.matches(USER_FAV_ANIMAL_VALIDATOR);
	}
	
	static boolean validatePassword(String userPassword) {
		return userPassword.matches(USER_PASSWORD_VALIDATOR);
	}

	boolean confirmPassword(String userId, String userPassword) throws UserNotFoundException;

	User signUp(User user);
	
	User getUserById(String userId) throws UserNotFoundException;
	
	boolean deleteUserByUserId(String userId) throws UserNotFoundException;
	
	List<User> getAllBloggers() throws UserNotFoundException;
	
	int changePassword(String password, String userId, String favFood, String favAnimal) throws UserNotFoundException;
	
	String encryptPassword(String userId, String userPassword) throws UserNotFoundException;
	
	boolean updatePassword(String userId, String oldPassword, String newPassword) throws UserNotFoundException;
	
	User getByUserName(String userName) throws UserNotFoundException;
}
