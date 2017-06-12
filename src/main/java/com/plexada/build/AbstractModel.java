/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import com.plexadasi.ebs.SiebelApplication.MyLogging;
import com.siebel.eai.SiebelBusinessServiceException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAP Training
 */
abstract public class AbstractModel 
{
    static StringWriter errors = new StringWriter();
    protected static Connection CONN;
    protected static Statement cs;
    private static PreparedStatement preparedStatement;
    protected String sqlQuery = "";
    protected static ResultSet rs = null;
    protected String setString = "";
    protected int length = 0;
    protected boolean returnBoolean = false;
    protected int returnInteger = 0;
    private String position;
    protected static final String UPDATE_CLAUSE = "UPDATE ";
    protected static final String SELECT_CLAUSE = "SELECT ";
    protected static final String INSERT_CLAUSE = "INSERT ";
    protected static final String FROM_CLAUSE = " FROM ";
    protected static final String SET_CLAUSE = "SET ";
    protected static final String WHERE_CLAUSE = "WHERE ";
    protected static final String AND_CLAUSE = "AND ";
    protected static final String OR_CLAUSE = "OR ";
    protected static final Integer INNER_JOIN = 0;
    protected static final Integer LEFT_JOIN = 1;
    protected static final Integer RIGHT_JOIN = 2;
    protected static final String ORDER_DESC = "DESC";
    protected static final String ORDER_ASC = "ASC";
    protected static final String POSITIONAL_PARAMETER = "?";
    protected static final String NEW_LINE = "\n";
    protected static final String EQUALS = "=";
    protected static final String WHITE_SPACE = " ";
    protected static final String NULL = "";
    protected static final String COMMA_SEPERATOR = ",";
    protected static final String IS_NULL = "IS NULL";
    private static final String PARAM_EXCEPTION = "Sql Parameter for insert statement cannot be empty.";
    private static final String ARRAY_SIZE_EXCEPTION = "Array returned empty when expecting at least one parameter.";
    private Integer startLimit;
    private Integer endLimit;
    
    public AbstractModel(Connection ebsConn)
    {
        CONN = ebsConn;
    }
    
    protected AbstractModel preparedStatement() throws SiebelBusinessServiceException
    {
        try 
        {
            preparedStatement = CONN.prepareStatement(sqlQuery);
            MyLogging.log(Level.SEVERE, "Sql Query Statement:"+sqlQuery);
            sqlQuery = "";
            MyLogging.log(Level.INFO, sqlQuery);
        } 
        catch (SQLException ex) {
            ex.printStackTrace(new PrintWriter(errors));
            MyLogging.log(Level.SEVERE, "Caught Sql Exception at prepared statement:"+errors.toString());
            throw new SiebelBusinessServiceException("SQL_EXCEPT", ex.getMessage());
        }
        return this;
    }
    
    public Boolean executeUpdate() throws SiebelBusinessServiceException
    {
        returnInteger = 0;
        try 
        {
            returnInteger = preparedStatement.executeUpdate();
            if(returnInteger > 0)
            {
                CONN.commit();
                returnBoolean = true;
            }
            else
            {
                CONN.rollback();
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace(new PrintWriter(errors));
            MyLogging.log(Level.SEVERE, "Caught Sql Exception at execute update method:"+errors.toString());
            throw new SiebelBusinessServiceException("SQL_EXCEPT", ex.getMessage());
        }
        return returnBoolean;
    }
    
    public void setInt(int index, int value) throws SiebelBusinessServiceException
    {
        try 
        {
            preparedStatement.setInt(index, value);
        } 
        catch (SQLException ex) {
            ex.printStackTrace(new PrintWriter(errors));
            MyLogging.log(Level.SEVERE, "Caught Sql Exception when setting number:"+errors.toString());
            throw new SiebelBusinessServiceException("SQL_EXCEPT", ex.getMessage());
        }
    }
    
    public void setString(int index, String value) throws SiebelBusinessServiceException
    {
        try 
        {
            preparedStatement.setString(index, value);
        } 
        catch (SQLException ex) {
            ex.printStackTrace(new PrintWriter(errors));
            MyLogging.log(Level.SEVERE, "Caught Sql Exception when setting string:"+errors.toString());
            throw new SiebelBusinessServiceException("SQL_EXCEPT", ex.getMessage());
        }
    }
    
    public void setArray(int index, Array value) throws SiebelBusinessServiceException
    {
        try 
        {
            preparedStatement.setArray(index, value);
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace(new PrintWriter(errors));
            MyLogging.log(Level.SEVERE, "Caught Sql Exception when setting array:"+errors.toString());
            throw new SiebelBusinessServiceException("SQL_EXCEPT", ex.getMessage());
        }
    }
    
    public String extractArray(String[] params) throws SiebelBusinessServiceException
    {
        
        length = params.length;
        setString = NULL;
        if(length <= 0)
        {
            throw new SiebelBusinessServiceException(ARRAY_SIZE_EXCEPTION);
        }
        for(String param : params)
        {
            returnInteger++;
            setString += param;   
            if(returnInteger != length)
            {
                setString += COMMA_SEPERATOR;
            }
        }
        return setString;
    }
    
    public String extractArrayPositionalParameter(String[] params) throws SiebelBusinessServiceException
    {
        length = params.length;
        setString = NULL;
        if(length <= 0)
        {
            throw new SiebelBusinessServiceException(ARRAY_SIZE_EXCEPTION);
        }
        for(String param : params)
        {
            returnInteger++;
            setString += param + EQUALS + POSITIONAL_PARAMETER;   
            if(returnInteger != length)
            {
                setString += COMMA_SEPERATOR;
            }
        }
        return setString;
    }
    
    public AbstractModel where(String column)
    {
        sqlQuery += WHITE_SPACE + WHERE_CLAUSE + column + EQUALS + POSITIONAL_PARAMETER;
        return this;
    }
    
    public AbstractModel where(String column, String value)
    {
        sqlQuery += WHITE_SPACE + WHERE_CLAUSE + column + EQUALS + value;
        return this;
    }
    
    public AbstractModel andWhere(String column)
    {
        sqlQuery += WHITE_SPACE + AND_CLAUSE + column + EQUALS + POSITIONAL_PARAMETER;
        return this;
    }
    
    public AbstractModel andWhere(String column, String value)
    {
        sqlQuery += WHITE_SPACE + AND_CLAUSE + column + EQUALS + value;
        return this;
    }
    
    public AbstractModel andIsNull(String column)
    {
        sqlQuery += WHITE_SPACE + AND_CLAUSE + column + WHITE_SPACE + IS_NULL;
        return this;
    }
    
    public ResultSet get() throws SiebelBusinessServiceException
    {
        try 
        {
            rs = preparedStatement.executeQuery();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace(new PrintWriter(errors));
            MyLogging.log(Level.SEVERE, "Caught Sql Exception:"+errors.toString());
            throw new SiebelBusinessServiceException("SQL_EXCEPT", ex.getMessage());
        }
        return rs;
    }
    
    public AbstractModel orWhere(String column)
    {
        sqlQuery += WHITE_SPACE + OR_CLAUSE + column + EQUALS + POSITIONAL_PARAMETER;
        return this;
    }
    
    public AbstractModel like()
    {
        return this;
    }
    
    public AbstractModel andLike()
    {
        return this;
    }
    
    public AbstractModel orLike()
    {
        return this;
    }
    
    
    public AbstractModel orderBy(String column, String order)
    {
        sqlQuery += "ORER BY " + column + order;
        return this;
    }
    
    protected String joinPosition(Integer point)
    {
        switch(point)
        {
            case 0:
               position = "INNER JOIN"; 
            break;
            case 1:
               position = "LEFT JOIN"; 
            break;
            case 2:
               position = "RIGHT JOIN"; 
            break;
            default:
               throw new SiebelBusinessServiceException("RANGE_EXCPT", "Out of range exception."); 
        }
        return position;
    }
    
    public void close() throws SiebelBusinessServiceException
    {
        try 
        {
            preparedStatement.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace(new PrintWriter(errors));
            MyLogging.log(Level.SEVERE, "Caught Sql Exception:"+errors.toString());
            throw new SiebelBusinessServiceException("SQL_EXCEPT", ex.getMessage());
        }
    }
}
