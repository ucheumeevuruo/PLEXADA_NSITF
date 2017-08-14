/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

/**
 *
 * @author SAP Training
 */
public class Request {
    public Request()
    {
        
    }
    
    public Company company()
    {
        return new Company();
    }
    
    public OwnersParticular particular()
    {
        return new OwnersParticular();
    }
}
