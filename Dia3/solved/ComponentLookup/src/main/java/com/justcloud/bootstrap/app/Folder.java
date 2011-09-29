package com.justcloud.bootstrap.app;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.springframework.stereotype.Component;

/**
 *
 * @author iamedu
 */
@Component
public class Folder {
    
    private Page main;
    
    
    private List<Page> middle;
    
    @Inject
    @Last
    private Page last;
    
    @Inject
    public Folder(@Main Page main) {
        this.main = main;
    }
    
    public void setLast(Page last) {
        this.last = last;
    }
    
    public Page getLast() {
        return last;
    }

    public Page getMain() {
        return main;
    }

    public List<Page> getMiddle() {
        return middle;
    }

    @Inject
    public void setMiddle(@Middle Provider<Page> middleProvider) {
        middle = new ArrayList<Page>();
        for(int i = 0; i < 10; i++) {
            middle.add(middleProvider.get());
        }
    }
    
    
    
    
}
