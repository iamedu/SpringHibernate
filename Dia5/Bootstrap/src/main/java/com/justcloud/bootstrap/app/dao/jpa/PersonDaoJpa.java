package com.justcloud.bootstrap.app.dao.jpa;

import com.justcloud.bootstrap.app.dao.PersonDao;
import com.justcloud.bootstrap.app.domain.Person;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

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
        
        Query query = entityManager.createNamedQuery("getPersonByUsername");
        query.setParameter("username", username);
        
        results = query.getResultList();
        if(results == null || results.size() <= 0) {
            throw new EntityNotFoundException(username + " not found");
        }
        return results.get(0);
    }
    
    public Person getPersonByUsernameCriteria(String username) {
    	//from Person as p where username = :username
    	
    	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    	CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
    	Root<Person> root = criteriaQuery.from(Person.class);
    	Path<String> path = root.<String>get("username");
    	criteriaQuery.where(criteriaBuilder.equal(path, username));
    	
    	return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
    
    public Person getPersonByUsernameNative(String username) {
    	Query query = entityManager.createNativeQuery("SELECT * FROM person WHERE username = ?", Person.class);
    	query.setParameter(1, username);
    	return (Person) query.getSingleResult();
    }
    
}
