package com.justcloud.bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class BootstrapStart 
{
    private ApplicationContext applicationContext;
    
    public BootstrapStart() {
        applicationContext = new ClassPathXmlApplicationContext("/META-INF/spring/spring-master.xml");
    }
    
    public void run() {
        
    }

    public void end() {
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.destroy();
    }

    
    public static void main( String[] args )
    {
        BootstrapStart app = new BootstrapStart();
        app.run();
        app.end();
    }
}
