package com.justcloud.bootstrap.app.dao.jpa;

import org.springframework.stereotype.Repository;

import com.justcloud.bootstrap.app.dao.PostDao;
import com.justcloud.bootstrap.app.domain.Post;

@Repository
public class PostDaoJpa extends GenericDaoJpa<Post> implements PostDao {

	public PostDaoJpa() {
		super(Post.class);
	}

}
