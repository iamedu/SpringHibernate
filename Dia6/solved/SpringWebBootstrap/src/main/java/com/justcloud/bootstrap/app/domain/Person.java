package com.justcloud.bootstrap.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

/**
 *
 * @author iamedu
 */
@Entity
@SequenceGenerator(name="PERSON_SEQ", sequenceName = "PERSON_SEQ")
public class Person implements Serializable, DomainObject {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4292994249825425975L;
	private Long id;
    private Long version;
    private String username;
    private List<Post> posts;
    
    public Person() {
    	posts = new ArrayList<Post>();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PERSON_SEQ")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @OneToMany(mappedBy = "author", cascade=CascadeType.ALL)
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
    
}
