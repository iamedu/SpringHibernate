package com.justcloud.bootstrap.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity(name="postcomments")
@SequenceGenerator(name="POSTCOMMENT_SEQ", sequenceName = "POSTCOMMENT_SEQ")
public class Comment  implements Serializable, DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1834065055315033878L;
	
	private Long id;
    private Long version;
    
    
    private String comment;
    
    private Post post;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="POSTCOMMENT_SEQ")
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

    @Column(name="textcomment",length=1024)
    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@ManyToOne
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
    
    

}
