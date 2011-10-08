package com.justcloud.bootstrap.app.mvc.controller;

import com.justcloud.bootstrap.app.dto.PersonDTO;
import com.justcloud.bootstrap.app.service.PersonFacade;
import com.justcloud.bootstrap.app.service.BlogFacade;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String showHomePage(Map<String, Object> model, HttpSession session) {
        model.put("postList", blogFacade.getLastPosts(10));
        
        System.out.println(session);
        
        return "home";
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/person")
    public String showPersonForm(Model model) {
        model.addAttribute(new PersonDTO());
        return "person";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/person")
    public String createPerson(@Valid PersonDTO person, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()) {
            return "person";
        }
        
        return "home";
    }
    
    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    public void setBlogFacade(BlogFacade blogFacade) {
        this.blogFacade = blogFacade;
    }
    
    
    
}
