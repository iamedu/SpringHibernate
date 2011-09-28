package com.justcloud.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author iamedu
 */
public class DataReaderService {
    private ApplicationContext ctx;
    private Reader reader;
    
    public DataReaderService() {
        ctx = new ClassPathXmlApplicationContext("/reader-beans.xml");
    }
    
    public String getData() {
        reader = (Reader)ctx.getBean("fileReader");
        return reader.fetchData();
    }
    
}
