/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.build.Company;
import com.plexada.build.OwnersParticular;
import com.plexada.doa.StateMapper;
import com.plexada.model.impl.Address;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SAP Training
 */
public class CompanyService{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private static final String TABLE = "company";
    private String SQL;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }

    public void insert(Company company, OwnersParticular particular){
        SQL = "insert into " + TABLE + "(id, name, rc_number, email, mobile_number, state, province, region, branch, block_no, street_address, position,owner) values (AUTO_INCREMENT.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplateObject.update( SQL, 
            company.getCompany(), 
            company.getIncNumber(), 
            company.getEmail(), 
            company.getPhoneNumber(), 
            company.getState(), 
            company.getProvince(),
            company.getRegion(),
            company.getBranch(),
            company.getHouseNo(),
            company.getStreetName(),
            particular.getPosition(),
            (particular.getFirstName() + " " + particular.getLastName())
        );
        System.out.println(SQL);
    }
    
    public Boolean update(Company company, OwnersParticular particular){
        Boolean returns = false;
        SQL = "UPDATE TABLE SET NAME = ?, RC_NUMBER = ?, EMAIL = ?, MOBILE_NUMBER = ?, STATE = ?, PROVINCE = ?, REGION = ?, BRANCH = ?, BLOCK_NO = ?, STREET_ADDRESS = ?, POSITION = ?, OWNER = ? WHERE ID = ?";
        int updateSql = jdbcTemplateObject.update(SQL, 
            company.getCompany(), 
            company.getIncNumber(), 
            company.getEmail(), 
            company.getPhoneNumber(), 
            company.getState(), 
            company.getProvince(),
            company.getRegion(),
            company.getBranch(),
            company.getHouseNo(),
            company.getStreetName(),
            particular.getPosition(),
            particular.getLastName()
        );
        if(updateSql > 0){
            returns = true;
        }
        return returns;
    }
    
    public List<Map<String, Object>> findByObjectId(String Id) {
        Id = "%" + Id + "%";
        SQL = "select * from " + TABLE + " WHERE RC_NUMBER LIKE ? OR NAME LIKE ?";
        List<Map<String, Object>> address = jdbcTemplateObject.query(SQL, 
           new Object[]{Id, Id}, new CompanyMapper());
        System.out.println(SQL);    
        return address;
    }

    //@Override
    public List<Map<String, Object>> findById(String Id) {
        SQL = "select * from " + TABLE + " WHERE ID = ?";
        List<Map<String, Object>> address = jdbcTemplateObject.query(SQL, 
           new Object[]{Id}, new CompanyMapper());
        System.out.println(SQL);    
        return address;
    }

    public int findTotalCustomer() {
        SQL = "select count(state_id) from states";
        List <Address> address = jdbcTemplateObject.query(SQL, new StateMapper());
        System.out.println(SQL);
        return address.size();
    }
    
}
