package com.justcloud.bootstrap;

import com.justcloud.bootstrap.app.domain.Post;
import com.justcloud.bootstrap.app.mvc.controller.HomeController;
import com.justcloud.bootstrap.app.service.BlogFacade;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 *
 * @author iamedu
 */
public class ControllerTest {

    @Test
    public void testHome() {
        List<Post> postList = new ArrayList<Post>();

        for (int i = 0; i < 10; i++) {
            postList.add(new Post());
        }
        
        BlogFacade blogFacade = mock(BlogFacade.class);
        HomeController homeController = new HomeController();
        homeController.setBlogFacade(blogFacade);
        
        when(blogFacade.getLastPosts(10)).
                thenReturn(postList);
        
        HashMap<String, Object> model = new HashMap<String, Object>();
        
        //String viewName = homeController.showHomePage(model);
        
        //Assert.assertEquals("home", viewName);
        
        //Assert.assertEquals(postList, model.get("postList"));

    }
}
