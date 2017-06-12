/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import static com.plexada.build.AbstractModel.SELECT_CLAUSE;
import java.sql.Connection;

/**
 *
 * @author SAP Training
 */
public class CI_Model extends AbstractModel{

    
    public CI_Model(Connection ebsConn)
    {
        super(ebsConn);
    }
    
    public AbstractModel select(String param)
    {
        sqlQuery += SELECT_CLAUSE + param;
        return this;
    }
    
    public AbstractModel select(String[] params)
    {
        sqlQuery += SELECT_CLAUSE;
        extractArray(params);
        return this;
    }
    
    public AbstractModel from(String table) 
    {
        sqlQuery += FROM_CLAUSE + table;
        return this;
    }
    
    public AbstractModel from(String[] tables)
    {
        sqlQuery += FROM_CLAUSE;
        extractArray(tables);
        return this;
    }
    
    public AbstractModel join(String table, String joins, Integer position)
    {
        
        sqlQuery += WHITE_SPACE + joinPosition(position) + WHITE_SPACE + table + " ON " + joins;
        return this;
    }
    
    public AbstractModel update(String table, String[] param) throws SiebelBusinessServiceException
    {
        sqlQuery += UPDATE_CLAUSE + table + WHITE_SPACE + SET_CLAUSE ;
        extractArrayPositionalParameter(param);
        return this;
    }
}
