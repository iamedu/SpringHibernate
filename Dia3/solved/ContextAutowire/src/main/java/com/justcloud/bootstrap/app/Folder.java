package com.justcloud.bootstrap.app;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author iamedu
 */
public class Folder {
    
    private Page main;
    
    @Autowired
    @Last
    private Page last;
    
    @Autowired
    public Folder(@Main Page main) {
        this.main = main;
    }
    
    public void setLast(Page last) {
        this.last = last;
    }
    
    public Page getLast() {
        return last;
    }

    public Page getMain() {
        return main;
    }
    
    
}
