package com.justcloud.evemtios;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.justcloud.evemtios.event.KeyboardLoop;

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
        
        /*
        ScopeTest test = (ScopeTest)applicationContext.getBean("scopeTest");
        test.test();
        */
        
        KeyboardLoop loop = (KeyboardLoop)applicationContext.getBean("keyboardLoop");
        loop.run();
        
    }
    
    public void end() {
    	ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext)applicationContext;
    	context.destroy();
    }
    
    public static void main( String[] args )
    {
        App app = new App();
        app.run();
        app.end();
    }
}
