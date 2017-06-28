/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.doa.StateMapper;
import com.plexada.model.impl.Address;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SAP Training
 */
public class AddressService{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private static final String TABLE = "s_addr_per";
    private String SQL;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }

    public void insert(Address address){
        String staffId = "1-FG5";
        SQL = "insert into " + TABLE + "(row_id, CREATED_BY, addr_name, LAST_UPD, LAST_UPD_BY, ADDR, CITY, PROVINCE, STATE, COUNTRY) values (?,?,?,?,?,?,?,?,?)";
        jdbcTemplateObject.update( SQL, "", staffId, address.getStreetName(), "sysdate", staffId, address.getStreetName(), address.getCity(), address.getProvince(), address.getState(), address.getCountry());
        System.out.println(SQL);
    }
    
    public Address findByObjectId(int Id) {
        SQL = "select * from " + TABLE + " where row_id = ?";
        Address address = (Address)jdbcTemplateObject.queryForObject(SQL, 
           new Object[]{Id}, new StateMapper());
        System.out.println(SQL);    
        return address;
    }

    //@Override
    public List<Address> findAll() {
        SQL = "select * from " + TABLE;
        List <Address> address = jdbcTemplateObject.query(SQL, new StateMapper());
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
