package com.cg.cric24.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="blog_id_seq",strategy = "increment")
@Table(name = "blogs")
public class Blog {
	
	public Blog() {
	}

	
	@Id
	@Column(name="blog_Id")
	@GeneratedValue(generator = "blog_id_seq",strategy = GenerationType.SEQUENCE)
	private int blogId;
	
	@Column(name = "blog_type")
	private String blogType;
	
	@Column(name = "blog_heading")
	private String blogHeading;
	
	@Column(name = "blog_content")
	private String blogContent;
	
//	@ManyToOne
//	@JoinColumn(name = "creator_id", referencedColumnName = "user_Id")
//	private User creator;
	
	@Column(name="status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Blog(int blogId, String blogType, String blogHeading, String blogContent) {
		this.blogId = blogId;
		this.blogType = blogType;
		this.blogHeading = blogHeading;
		this.blogContent = blogContent;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogType() {
		return blogType;
	}

	public void setBlogType(String blogType) {
		this.blogType = blogType;
	}

	public String getBlogHeading() {
		return blogHeading;
	}

	public void setBlogHeading(String blogHeading) {
		this.blogHeading = blogHeading;
	}

	public Blog(String blogType, String blogHeading, String blogContent) {
		super();
		this.blogType = blogType;
		this.blogHeading = blogHeading;
		this.blogContent = blogContent;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	
	

}
