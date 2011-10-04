package com.justcloud.bootstrap.app.dao.jpa;

import com.justcloud.bootstrap.app.dao.GenericDao;
import com.justcloud.bootstrap.app.domain.DomainObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

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

}

