package com.justcloud.spring1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DataReaderService service = new DataReaderService();
        System.out.println( "Hello World! " + service.getData());
    }
}
