/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model;

/**
 *
 * @author SAP Training
 */
public class Employees {
    private String name;
    private long id;
    private String contactNumber;
 
    // standard getters and setters
    public void setName(String set)
    {
        name = set;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setId(long set)
    {
        id = set;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setContactNumber(String set)
    {
        contactNumber = set;
    }
    
    public String getContactNumber()
    {
        return contactNumber;
    }
}
