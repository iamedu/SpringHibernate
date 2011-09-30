package com.justcloud.bootstrap.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author iamedu
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person implements Serializable, DomainObject {
    private List<Post> posts;
    
    private Long id;
    private Long version;
    private String username;
    private String password;
    
    public Person() {
        posts = new ArrayList<Post>();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "person", orphanRemoval=true, cascade= CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
}
