package com.justcloud.bootstrap.app.dao;

import com.justcloud.bootstrap.app.domain.DomainObject;
import java.util.List;

/**
 *
 * @author iamedu
 */
public interface GenericDao<T extends DomainObject> {
    
    public T get(Long id);
    public List<T> getAll();
    public void save(T object);
    public void delete(T object);
    
}
