package com.cg.cric24.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name = "user_seq", strategy = "increment")
public class User {
	
	public User() {
	}
	
	@Id
	@Column(name = "user_Id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_phone")
	private long userPhone;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "user_fav_food")
	private String userFavFood;
	
	@Column(name = "user_fav_animal")
	private String userFavAnimal;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	} 

	public User(int userId, String userName, String userPassword, long userPhone, String userEmail, String userType,
			String userFavFood, String userFavAnimal) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userType = userType;
		this.userFavFood = userFavFood;
		this.userFavAnimal = userFavAnimal;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserFavFood() {
		return userFavFood;
	}

	public void setUserFavFood(String userFavFood) {
		this.userFavFood = userFavFood;
	}

	public String getUserFavAnimal() {
		return userFavAnimal;
	}

	public void setUserFavAnimal(String userFavAnimal) {
		this.userFavAnimal = userFavAnimal;
	}
}
