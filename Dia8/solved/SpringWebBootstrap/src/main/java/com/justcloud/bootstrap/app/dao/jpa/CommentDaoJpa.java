package com.justcloud.bootstrap.app.dao.jpa;

import org.springframework.stereotype.Repository;

import com.justcloud.bootstrap.app.dao.CommentDao;
import com.justcloud.bootstrap.app.domain.Comment;

@Repository
public class CommentDaoJpa extends GenericDaoJpa<Comment> implements CommentDao {

	public CommentDaoJpa() {
		super(Comment.class);
	}

}
