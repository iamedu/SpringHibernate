package com.justcloud.bootstrap.app.dao;

import com.justcloud.bootstrap.app.domain.Person;
import javax.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;


/**
 *
 * @author iamedu
 */
public interface PersonDao extends GenericDao<Person> {
    
    public Person getPersonByUsername(String username) throws DataAccessException, EntityNotFoundException;
    
}
