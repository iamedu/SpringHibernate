package com.justcloud.bootstrap;

import com.justcloud.bootstrap.app.dao.PersonDao;
import com.justcloud.bootstrap.app.domain.Person;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iamedu
 */
@Component
public class App {
    
    @Inject
    private PersonDao personDao;
    
    @Transactional
    public void start() {
        Person person = new Person();
        person.setUsername("username");
        
        personDao.save(person);
        System.out.println("Person saved " + person.getId());
        
        person = personDao.getPersonByUsername("username");
        System.out.println("Person found " + person.getId());
    }
    
    
}
