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
public class QuerySet {
    private final Integer[] limit = new Integer[2];
    
    public void limit(Integer count)
    {
        limit[0] = count;
    }
    
    public void limit(Integer count, Integer offset)
    {
        limit[0] = count;
        limit[1] = offset;
    }
    
    public void ordering()
    {
        
    }
}
