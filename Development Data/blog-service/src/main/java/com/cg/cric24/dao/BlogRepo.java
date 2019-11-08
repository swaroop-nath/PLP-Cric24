package com.cg.cric24.dao;

/**
 * 
 * This interface declares various custom queries.

 * @author Anirban
 * @version 1.0
 * 
 * 
 * 
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.cric24.dto.Blog;


@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer>{

	/**
	 * Custom query for displaying all blogs
	 * @return It will return list of blogs
	 */
	@Query("SELECT b FROM Blog b")
	public List<Blog> allBlogs();
	
	/**
	 * Custom query to approve a blog
	 * @param blgId
	 * @return returns 1 when blog is approved
	 */
	@Modifying
	@Query("UPDATE Blog b SET b.status = 'Approved' WHERE b.blogId=:blgId")
	public int approveBlog(int blgId);

	/**
	 * Custom query to reject a blog
	 * @param blgId
	 * @return returns 1 when blog is rejected
	 */
	@Modifying
	@Query("UPDATE Blog b SET b.status = 'Rejected' WHERE b.blogId=:blgId")
	public int rejectBlog(int blgId);
	
	
	/**
	 * Custom query to display a list of blogs of a particular type
	 * @param type
	 * @return returns a list of blogs object based on the query
	 */
	@Query("SELECT b FROM Blog b where b.blogType=:type")
	public List<Blog> searchByCategory(String type);
}
