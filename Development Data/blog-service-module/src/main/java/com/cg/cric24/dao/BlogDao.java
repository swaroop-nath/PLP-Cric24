package com.cg.cric24.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.dto.Blog;

@Transactional
@Repository
public interface BlogDao extends JpaRepository<Blog, Integer>{
	
	@Modifying
	@Query("UPDATE Blog b SET b.status = 'Rejected' WHERE b.blogId=:crtrId")
	public int rejectBlog(int crtrId);
	
	@Modifying
	@Query("UPDATE Blog b SET b.status = 'Approved' WHERE b.blogId=:crtrId")
	public int approveBlog(int crtrId);

	@Query("SELECT b FROM Blog b where b.status='Approved'")
	public List<Blog> approvedBlogs();
	
}
