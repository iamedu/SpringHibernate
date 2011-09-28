package com.justcloud.spring1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FileReader reader = new FileReader("test.txt");
        
        System.out.println( "Hello World! " + reader.fetchData());
    }
}
