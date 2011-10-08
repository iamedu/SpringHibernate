package com.justcloud.bootstrap.app.service.impl;

import com.justcloud.bootstrap.app.domain.Post;
import com.justcloud.bootstrap.app.service.BlogFacade;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author iamedu
 */
@Service
public class BlogFacadeImpl implements BlogFacade {

    @Override
    public List<Post> getLastPosts(int limit) {
        return null;
    }
    
}
