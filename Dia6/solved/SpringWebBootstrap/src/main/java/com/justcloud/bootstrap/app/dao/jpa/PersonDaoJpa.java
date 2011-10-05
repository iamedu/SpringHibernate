package com.justcloud.bootstrap.app.dao.jpa;

import com.justcloud.bootstrap.app.dao.PersonDao;
import com.justcloud.bootstrap.app.domain.Person;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iamedu
 */
@Repository
public class PersonDaoJpa extends GenericDaoJpa<Person> implements PersonDao {

    public PersonDaoJpa() {
        super(Person.class);
    }
    
    public Person getPersonByUsername(String username) throws DataAccessException, EntityNotFoundException {
        List<Person> results = null;
        
        Query query = entityManager.createQuery("from Person as p where p.username = :username");
        query.setParameter("username", username);
        
        results = query.getResultList();
        if(results == null || results.size() <= 0) {
            throw new EntityNotFoundException(username + " not found");
        }
        return results.get(0);
    }
}
