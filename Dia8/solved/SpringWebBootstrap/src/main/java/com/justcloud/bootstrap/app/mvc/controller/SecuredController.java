package com.justcloud.bootstrap.app.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author iamedu
 */
@Controller
@RequestMapping("/secured")
public class SecuredController {
    
    @RequestMapping("/test")
    public String showTest(Model model) {
        
        
        return "secured/test";
    }
    
}
