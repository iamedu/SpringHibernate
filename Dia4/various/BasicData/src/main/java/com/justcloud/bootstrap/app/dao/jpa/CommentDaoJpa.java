package com.justcloud.bootstrap.app.dao.jpa;

import com.justcloud.bootstrap.app.dao.CommentDao;
import com.justcloud.bootstrap.app.domain.Comment;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iamedu
 */
@Repository
public class CommentDaoJpa extends GenericDaoJpa<Comment> implements CommentDao {
    
    public CommentDaoJpa() {
        super(Comment.class);
    }
    
}
