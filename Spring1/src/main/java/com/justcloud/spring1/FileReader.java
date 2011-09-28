package com.justcloud.spring1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iamedu
 */

public class FileReader {
    private String fileName;
    private StringBuilder builder;
    
    public FileReader(String fileName) {
        this.fileName = fileName;
        builder = new StringBuilder();
    }
    
    public String fetchData() {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNext()) {
                builder.append(scanner.next());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.toString();
    }
    
}
