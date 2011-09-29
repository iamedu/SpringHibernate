package com.justcloud.bootstrap;

import com.justcloud.bootstrap.app.Folder;
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
        Folder folder = applicationContext.getBean(Folder.class);
        
        System.out.println("Main page" + folder.getMain());
        System.out.println("Last page" + folder.getLast());
        
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
