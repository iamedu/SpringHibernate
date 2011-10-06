package com.justcloud.bootstrap.app.mvc.controller;

import com.justcloud.bootstrap.app.service.PersonFacade;
import com.justcloud.bootstrap.app.service.BlogFacade;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author iamedu
 */
@Controller
public class HomeController {
    
    @Inject
    private PersonFacade personFacade;
    
    @Inject
    private BlogFacade blogFacade;
    
    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("postList", blogFacade.getLastPosts(10));
        return "home";
    }

    public void setBlogFacade(BlogFacade blogFacade) {
        this.blogFacade = blogFacade;
    }
    
    
    
}
