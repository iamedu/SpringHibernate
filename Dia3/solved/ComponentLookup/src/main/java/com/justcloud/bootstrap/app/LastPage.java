package com.justcloud.bootstrap.app;

import org.springframework.stereotype.Component;

/**
 *
 * @author iamedu
 */
@Last
@Component
public class LastPage implements Page {

    public String getName() {
        return "last";
    }
    
}
