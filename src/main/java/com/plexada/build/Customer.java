/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.sql.Date;

/**
 *
 * @author SAP Training
 */
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private Date created_date;
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the created_date
     */
    public Date getCreatedDate() {
        return created_date;
    }

    /**
     * @param created_date the created_date to set
     */
    public void setCreatedDate(Date created_date) {
        this.created_date = created_date;
    }    
}
