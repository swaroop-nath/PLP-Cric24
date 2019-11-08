package com.cg.cric24.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.dto.Blog;
import com.cg.cric24.exception.BlogNotFoundException;

@Repository
public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	private EntityManager mgr;

	@Override
	public Blog addBlog(Blog blog) {

		Blog newBlog = mgr.merge(blog);
		mgr.flush();
		return newBlog;
	}

	@Override
	public List<Blog> allBlogs() {
		return mgr.createNamedQuery("all_blogs").getResultList();
	}

	@Override
	public int approveBlog(int blgId) {
		return mgr.createNamedQuery("approve_blog").setParameter("blgId", blgId).getFirstResult();
	}

	@Override
	public int rejectBlog(int blgId) {
		return mgr.createNamedQuery("reject_blog").setParameter("blgId", blgId).getFirstResult();
	}

	@Override
	public List<Blog> searchByCategory(String type) throws BlogNotFoundException {
		List<Blog> blogs = mgr.createNamedQuery("by_category").setParameter("type",type ).getResultList();
		if(blogs.size()==0) {
			throw new BlogNotFoundException("No blogs are present in this category");
		}
		else {
			return blogs;
		}
	}

}
