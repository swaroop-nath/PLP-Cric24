package com.cg.Cric24.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Cric24.entity.User;

public interface LoginDao extends JpaRepository<User, String> {
	
	/**
	 * This method is used to get all the bloggers from the database
	 * @param it takes user type as input which is by default set to blogger
	 * @return the list of all the bloggers in the database
	 */
	@Query("from User u where u.userType=:userType")
	List<User> getAllBloggers(String userType);
	
	/**
	 * This method is used to used to change password of a user 
	 * @param it takes password of the user to confirm it
	 * @param it takes userId of the user to verify that a user exists with that Id
	 * @return int
	 */
	@Transactional
	@Modifying
	@Query("update User u set u.userPassword=:password where u.userId=:userId")
	int changePassword(String password, String userId); 
	
	/**
	 * This method is used to fetch the details of a user based on user name
	 * @param it takes user name to find the specific user in the database
	 * @return the data of the user
	 */
	@Query("from User u where u.userName=:userName")
	User getByUserName(String userName);
}
