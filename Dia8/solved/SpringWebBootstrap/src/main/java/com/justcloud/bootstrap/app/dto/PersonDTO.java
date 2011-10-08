package com.justcloud.bootstrap.app.dto;

import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author iamedu
 */
public class PersonDTO {
    private Long id;
    private Long version;
    
    @NotEmpty
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    
    
}
