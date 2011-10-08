package com.justcloud.bootstrap.app.service;

import com.justcloud.bootstrap.app.domain.Post;
import java.util.List;

/**
 *
 * @author iamedu
 */
public interface BlogFacade {
    
    public List<Post> getLastPosts(int limit);
    
}
