package com.cg.Cric24.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "users")
public class User {
	@Id
	private String userId;
	@Column(name = "user_Name")
	private String userName;
	@Column(name = "user_Password")
	private String userPassword;
	@Column(name = "user_Phone")
	private String userPhone;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_Type")
	private String userType;
	@Column(name = "user_fav_food")
	private String userFavFood;
	@Column(name = "user_fav_animal")
	private String userFavAnimal;
	@Transient
	private String confirmPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
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
