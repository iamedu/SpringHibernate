package com.justcloud.bootstrap.app.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author iamedu
 */
@Entity
@NamedQuery(name = "getPersonByUsername", query = "from Person as p where p.username = :username")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Person implements Serializable, DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4292994249825425975L;
	private Long id;
	private Long version;
	private String username;
	private List<Post> posts;
	
	private BigDecimal sueldo;

	public Person() {
		posts = new ArrayList<Post>();
	}

	@Id
	@SequenceGenerator(name = "PERSON_GEN", sequenceName = "PERSON_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_GEN")
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

	
	
	@Column(unique = true, nullable = false, insertable = true, updatable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void addPostToPerson(Post post) {
		post.setAuthor(this);
		posts.add(post);
	}

	@Column(scale=0, precision=10)
	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}
	
	

}
