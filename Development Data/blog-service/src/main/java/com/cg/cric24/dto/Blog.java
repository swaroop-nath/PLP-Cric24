package com.cg.cric24.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "blogs")
@SequenceGenerator(name = "blog_id_seq",sequenceName = "blog_seq", allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "all_blogs", query = "SELECT b FROM Blog b"),
	@NamedQuery(name = "approve_blog", query = "UPDATE Blog b SET b.status = 'Approved' WHERE b.blogId=:blgId"),
	@NamedQuery(name = "reject_blog", query = "UPDATE Blog b SET b.status = 'Rejected' WHERE b.blogId=:blgId"),
	@NamedQuery(name = "by_category", query = "SELECT b FROM Blog b where b.blogType=:type")
})
public class Blog {

	@Id
	@GeneratedValue(generator = "blog_id_seq", strategy = GenerationType.SEQUENCE)
	private int blogId;
	@NotEmpty(message= "Blog Type cannot be empty" )
	@Column(name = "blog_type")
	private String blogType;
	
	@NotEmpty(message= "Blog Heading cannot be empty" )
	@Column(name = "blog_heading", length = 2048 )
	private String blogHeading;
	
	@NotEmpty(message= "Blog Content cannot be empty" )
	@Column(name = "blog_content", length = 49090)
	private String blogContent;
	
	@Column(name = "status")
	private String status;
	
//	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "blogger_Id", referencedColumnName = "user_Id")
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
