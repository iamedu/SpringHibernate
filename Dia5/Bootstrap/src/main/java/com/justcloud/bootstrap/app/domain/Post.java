package com.justcloud.bootstrap.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="posttests")
public class Post implements DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 943742273292644999L;
	
	private Long id;
	private Long version;	
	private String title;
	private String body; 
	private Person author;
	private List<Comment> comments;
	
	public Post() {
		comments = new ArrayList<Comment>(); 
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Version
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
	@Column(length=128)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Lob
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@ManyToOne
	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Person author) {
		this.author = author;
	}
	
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addCommentToPost(Comment comment) {
		comment.setPost(this);
		comments.add(comment);
	}
	
}
