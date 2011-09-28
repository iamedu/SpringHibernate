package com.justcloud.evemtios;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    
    private ApplicationContext applicationContext;
    
    public App() {
        applicationContext = new ClassPathXmlApplicationContext("/spring-beans.xml");
    }
    
    public void run() {
        System.out.println( "Hello World!" );
    }
    
    public static void main( String[] args )
    {
        new App().run();
    }
}
