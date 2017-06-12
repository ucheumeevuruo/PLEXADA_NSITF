/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.sql.Array;
import java.sql.ResultSet;
import static org.testng.Assert.*;

/**
 *
 * @author SAP Training
 */
public class AbstractModelNGTest {
    
    public AbstractModelNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of preparedStatement method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testPreparedStatement() {
        System.out.println("preparedStatement");
        AbstractModel instance = null;
        AbstractModel expResult = null;
        AbstractModel result = instance.preparedStatement();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInt method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testSetInt() {
        System.out.println("setInt");
        int index = 0;
        int value = 0;
        AbstractModel instance = null;
        instance.setInt(index, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setString method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testSetString() {
        System.out.println("setString");
        int index = 0;
        String value = "";
        AbstractModel instance = null;
        instance.setString(index, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArray method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testSetArray() {
        System.out.println("setArray");
        int index = 0;
        Array value = null;
        AbstractModel instance = null;
        instance.setArray(index, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeUpdate method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testExecuteUpdate() {
        System.out.println("executeUpdate");
        AbstractModel instance = null;
        Boolean expResult = null;
        Boolean result = instance.executeUpdate();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of extractArrayPositionalParameter method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testSet() throws Exception {
        System.out.println("set");
        String[] param = null;
        AbstractModel instance = null;
        AbstractModel expResult = null;
        AbstractModel result = instance.extractArrayPositionalParameter(param);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of where method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testWhere_String() {
        System.out.println("where");
        String column = "";
        AbstractModel instance = null;
        AbstractModel expResult = null;
        AbstractModel result = instance.where(column);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of where method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testWhere_String_String() {
        System.out.println("where");
        String column = "";
        String value = "";
        AbstractModel instance = null;
        AbstractModel expResult = null;
        AbstractModel result = instance.where(column, value);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andWhere method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testAndWhere_String() {
        System.out.println("andWhere");
        String column = "";
        AbstractModel instance = null;
        AbstractModel expResult = null;
        AbstractModel result = instance.andWhere(column);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andWhere method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testAndWhere_String_String() {
        System.out.println("andWhere");
        String column = "";
        String value = "";
        AbstractModel instance = null;
        AbstractModel expResult = null;
        AbstractModel result = instance.andWhere(column, value);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andIsNull method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testAndIsNull() {
        System.out.println("andIsNull");
        String column = "";
        AbstractModel instance = null;
        AbstractModel expResult = null;
        AbstractModel result = instance.andIsNull(column);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testGet() {
        System.out.println("get");
        AbstractModel instance = null;
        ResultSet expResult = null;
        ResultSet result = instance.get();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of orWhere method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testOrWhere() {
        System.out.println("orWhere");
        String column = "";
        AbstractModel instance = null;
        AbstractModel expResult = null;
        AbstractModel result = instance.orWhere(column);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class AbstractModel.
     */
    @org.testng.annotations.Test
    public void testClose() {
        System.out.println("close");
        AbstractModel instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractModelImpl extends AbstractModel {

        public AbstractModelImpl() {
            super(null);
        }
    }
    
}
