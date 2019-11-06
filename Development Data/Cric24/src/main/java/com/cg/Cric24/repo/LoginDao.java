package com.cg.Cric24.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Cric24.entity.User;

public interface LoginDao extends JpaRepository<User, String> {

	@Query("from User u where u.userType=:userType")
	List<User> getAllBloggers(String userType);
	
	@Transactional
	@Modifying
	@Query("update User u set u.userPassword=:password where u.userId=:userId")
	int changePassword(String password, String userId); 
	
	@Query("from User u where u.userName=:userName")
	User getByUserName(String userName);
}
