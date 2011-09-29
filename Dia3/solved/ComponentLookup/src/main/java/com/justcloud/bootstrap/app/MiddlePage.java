package com.justcloud.bootstrap.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author iamedu
 */
@Middle
@Component
@Scope("prototype")
public class MiddlePage implements Page {

    public String getName() {
        return "middle";
    }
    
}
