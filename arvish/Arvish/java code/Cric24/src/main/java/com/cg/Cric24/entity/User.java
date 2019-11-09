package com.cg.Cric24.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
	@Id
	@NotEmpty (message= "User Id cannot  be empty")
	@Column(name = "user_Id")
	private String userId;
	@NotEmpty (message= "User Name cannot  be empty")
	@Column(name = "user_Name")
	private String userName;
	
	@NotEmpty (message= "User Password cannot  be empty")
	@Column(name = "user_Password")
	private String userPassword;
	
	@NotEmpty (message= "User Phone cannot  be empty")
	@Column(name = "user_Phone")
	private String userPhone;
	
	@NotEmpty (message= "User Email cannot  be empty")
	@Column(name = "user_Email")
	private String userEmail;
	
	@NotEmpty (message= "User Type cannot  be empty")
	@Column(name = "user_Type")
	private String userType;
	
	@NotEmpty (message= "User Favourite Food cannot  be empty")
	@Column(name = "user_Fav_Food")
	private String userFavFood;
	
	@NotEmpty (message= "User Favourite Animal cannot  be empty")
	@Column(name = "user_Fav_Animal")
	private String userFavAnimal;
	@OneToMany(mappedBy = "blogger", cascade = CascadeType.ALL)
	private List<Blog> blogs ;

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

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
