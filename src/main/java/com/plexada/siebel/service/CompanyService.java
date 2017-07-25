/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.siebel.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plexada.build.Company;
import java.util.List;
import java.util.Map;
import com.siebel.data.SiebelBusComp;
import com.siebel.data.SiebelBusObject;
import com.siebel.data.SiebelDataBean;
import com.siebel.data.SiebelException;
import com.siebel.data.SiebelPropertySet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author SAP Training
 */
public class CompanyService {
    
    /**
     *
     */
    protected static SiebelDataBean service = new SiebelDataBean();
    protected static SiebelPropertySet properties, values;
    protected SiebelBusComp sBusComp = new SiebelBusComp();
    protected Integer beginCount = 1;
    private static final String BO = "Account";
    private static final String BC = "Account";
    
    public CompanyService(SiebelDataBean conn) throws SiebelException, SiebelException
    {
        service = conn;
        SiebelBusObject sbBO = service.getBusObject(BO); 
        sBusComp = sbBO.getBusComp(BC);
        properties = values = service.newPropertySet();
    }
    
    public List<Company> find(String id) throws SiebelException{
        sBusComp.setViewMode(3);
        sBusComp.clearToQuery();
        values = service.newPropertySet();
        // Activate all the fields
        sBusComp.activateMultipleFields(this.searchProperties());
        //Get search specification
        sBusComp.setSearchSpec("Id", id);
        sBusComp.executeQuery2(true, true);
        return companyMapper();
    }
    
    public List<Company> find(String id, String incNum) throws SiebelException{
        sBusComp.setViewMode(3);
        sBusComp.clearToQuery();
        // Activate all the fields
        sBusComp.activateMultipleFields(this.searchProperties());
        //Get search specification
        if(!id.equals("")){
            sBusComp.setSearchSpec("Id", id);
        }
        if(!incNum.equals("")){
            sBusComp.setSearchSpec("Incorporation No", incNum);
        }
        sBusComp.executeQuery2(true, true);
        return companyMapper();
    }
    
    public List<Company> companyMapper() throws SiebelException{
        Company company = new Company();
        List<Map<String, String>> list = doTrigger(sBusComp);
        List<Company> companies = new ArrayList();
        for(Map<String, String> map : list){
            company.setId(map.get("id"));
            company.setCompany(map.get("company"));
            company.setEmail(map.get("email"));
            company.setIncNumber(map.get("incNumber"));
            company.setIncYear(map.get("incYear"));
            company.setStreetName(map.get("streetName"));
            company.setCity(map.get("city"));
            company.setState(map.get("state"));
            company.setProvince(map.get("province"));
            company.setCountry(map.get("country"));
            companies.add(company);
        }
        System.out.println(list);
        return companies;
    }
    
    private List<Map<String, String>> doTrigger(SiebelBusComp sbBC) throws SiebelException
    {
        List<Map<String, String>> list = new ArrayList();
        boolean isRecord = sbBC.firstRecord();
        while (isRecord)
        {
            sbBC.getMultipleFieldValues(properties, values);
            list.add(Service_PreInvokeMethod(properties, values));
            isRecord = sbBC.nextRecord();
        }
        return list;
    }
    
    private Map<String, String> Service_PreInvokeMethod (SiebelPropertySet Inputs, SiebelPropertySet Outputs)
    {
        String propName = Inputs.getFirstProperty(), propVal;
        Map<String, String> mapProperty = new HashMap();
        // stay in loop if the property name is not an empty string
        while (!"".equals(propName)){
            propVal = Outputs.getProperty(propName);
            // if a property with the same name does not exist
            // add the name value pair to the output
            if (Inputs.propertyExists(propName)) 
            {
                mapProperty.put(Inputs.getProperty(propName), propVal);
            }
            propName = Inputs.getNextProperty();

        }
        return mapProperty;
    }
    
    private SiebelPropertySet searchProperties() {
        properties.setProperty("Id", "id");
        properties.setProperty("Name", "company");
        //properties.setProperty("Account Number", "csn");
        properties.setProperty("Email Address", "email");
        properties.setProperty("Account Number", "incNumber");
        properties.setProperty("Year Established", "incYear");
        properties.setProperty("Street Address", "streetName");
        properties.setProperty("Province", "province");
        properties.setProperty("State", "state");
        properties.setProperty("Country", "country");
        //properties.setProperty("Account Type Code", "Account Type Code");
        //properties.setProperty("Category", "Category");
        //properties.setProperty("Tax ID Number", "Tax ID Number");
        //properties.setProperty("Total Staff Emolument", "Total Staff Emolument");
        return properties;
    }
}
