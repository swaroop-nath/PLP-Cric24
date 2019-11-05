package com.cg.cric24.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.cric24.dto.Blog;


@Repository
public interface BlogDao extends JpaRepository<Blog, Integer>{

	@Query("SELECT b FROM Blog b where b.status='Approved'")
	public List<Blog> approvedBlogs();
	
	@Modifying
	@Query("UPDATE Blog b SET b.status = 'Approved' WHERE b.blogId=:blgId")
	public int approveBlog(int blgId);

	@Modifying
	@Query("UPDATE Blog b SET b.status = 'Rejected' WHERE b.blogId=:blgId")
	public int rejectBlog(int blgId);
	
	@Query("SELECT b FROM Blog b where b.blogType=:type")
	public List<Blog> searchByCategory(String type);
}
