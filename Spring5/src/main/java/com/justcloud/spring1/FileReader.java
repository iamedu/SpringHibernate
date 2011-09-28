package com.justcloud.spring1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iamedu
 */

public class FileReader implements Reader {
    private String fileName;
    private StringBuilder builder;
    
    private String parametro3;
    
    public FileReader(Dummy parametro1, Set<Integer> parametro2, String parametro3) {
        builder = new StringBuilder();
        this.parametro3 = parametro3;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
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
        return builder.toString() + " " + parametro3;
    }
    
    public void setProps(Properties props) {
        
    }
    
    public void setMap(Map map) {
        
    }
    
}
