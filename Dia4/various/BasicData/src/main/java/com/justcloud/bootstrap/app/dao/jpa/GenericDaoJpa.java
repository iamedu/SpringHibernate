package com.justcloud.bootstrap.app.dao.jpa;

import com.justcloud.bootstrap.app.dao.GenericDao;
import com.justcloud.bootstrap.app.domain.DomainObject;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.dao.DataAccessException;

@SuppressWarnings("unchecked")
public class GenericDaoJpa<T extends DomainObject> implements GenericDao<T> {

    private Class<T> type;

    protected EntityManager entityManager;

    public GenericDaoJpa(Class<T> type) {
        super();
        this.type = type;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T get(Long id) {
        return (T) entityManager.find(type, id);
    }

    public List<T> getAll() {
        return entityManager.createQuery("select obj from " + type.getName() + " obj").getResultList();
    }

    public void save(T object) throws DataAccessException {
        entityManager.persist(object);
    }

    public void delete(T object) throws DataAccessException {
        entityManager.remove(object);
    }

    public void indexEntity(T object) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.index(object);
    }

    public void indexAllItems() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        List results = fullTextEntityManager.createQuery("from " + type.getCanonicalName()).getResultList();
        int counter = 0, numItemsInGroup = 10;
        Iterator resultsIt = results.iterator();
        while (resultsIt.hasNext()) {
            fullTextEntityManager.index(resultsIt.next());
            if (counter++ % numItemsInGroup == 0) {
                fullTextEntityManager.flushToIndexes();
                fullTextEntityManager.clear();
            }
        }
    }

    
}

