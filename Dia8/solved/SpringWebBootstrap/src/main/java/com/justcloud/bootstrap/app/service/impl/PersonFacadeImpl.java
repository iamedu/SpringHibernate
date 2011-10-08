package com.justcloud.bootstrap.app.service.impl;

import com.justcloud.bootstrap.app.dao.PersonDao;
import com.justcloud.bootstrap.app.service.PersonFacade;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author iamedu
 */
@Service
public class PersonFacadeImpl implements PersonFacade {
    
    @Inject
    private PersonDao personDao;
    
}
