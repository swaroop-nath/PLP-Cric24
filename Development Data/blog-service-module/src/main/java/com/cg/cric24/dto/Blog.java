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
@GenericGenerator(name="creator_id_seq",strategy = "increment")
@Table(name = "blogs")
public class Blog {
	
	public Blog() {
	}
	
	@Id
	@Column(name="creator_Id")
	@GeneratedValue(generator = "creator_id_seq",strategy = GenerationType.SEQUENCE)
	private int creatorId;
	
	@Column(name = "blog_type")
	private String blogType;
	
	@Column(name = "blog_heading")
	private String blogHeading;
	
	@Column(name = "blog_content")
	private String blogContent;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "creator_id", referencedColumnName = "user_Id")
	private User creator;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Blog(int creatorId, String blogType, String blogHeading, String blogContent) {
		this.creatorId = creatorId;
		this.blogType = blogType;
		this.blogHeading = blogHeading;
		this.blogContent = blogContent;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
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

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	
	

}
