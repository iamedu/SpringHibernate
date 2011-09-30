package com.justcloud.bootstrap.app.spring;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 *
 * @author iamedu
 */
@Configuration
public class SpringConfig {
    
    @Value("#{ '${jdbc.driverClassName}' }")
    private String driverClassName;
    
    @Value("#{ '${jdbc.url}' }")
    private String url;
    
    @Value("#{ '${jdbc.username}' }")
    private String username;
    
    @Value("#{ '${jdbc.password}' }")
    private String password;
    
    @Bean(name="dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
    
    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        return factory;
    }
    
}
