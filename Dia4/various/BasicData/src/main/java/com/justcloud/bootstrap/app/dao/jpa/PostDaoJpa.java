package com.justcloud.bootstrap.app.dao.jpa;

import com.justcloud.bootstrap.app.dao.PostDao;
import com.justcloud.bootstrap.app.domain.Post;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iamedu
 */
@Repository
public class PostDaoJpa extends GenericDaoJpa<Post> implements PostDao {
    public PostDaoJpa() {
        super(Post.class);
    }
}
