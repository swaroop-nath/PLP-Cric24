package com.cg.cric24.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blogs")
public class Blog {

	@Id
	@GeneratedValue(generator = "blog_id_seq", strategy = GenerationType.SEQUENCE)
	private int blogId;
	@Column(name = "blog_type")
	private String blogType;
	@Column(name = "blog_heading", length = 2048 )
	private String blogHeading;
	@Column(name = "blog_content", length = 49090)
	private String blogContent;
	@Column(name = "status")
	private String status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blogger_Id")
	private User blogger;
	

	public User getBlogger() {
		return blogger;
	}

	public void setBlogger(User blogger) {
		this.blogger = blogger;
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

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
