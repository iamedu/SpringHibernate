package com.justcloud.bootstrap.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author iamedu
 */
@Main
@Component
public class MainPage implements Page {

    @Value("main")
    private String name;
    
    public String getName() {
        return name;
    }
    
}
