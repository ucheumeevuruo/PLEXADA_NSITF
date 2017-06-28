/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.build.Company;
import com.plexada.build.Customer;
import com.plexada.model.StudentMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SAP Training
 */
public class RegisterService {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    public void create(Company company) {
        String SQL = "INSERT INTO CUSTOMER (NAME, EMAIL) values (?, ?)";
        jdbcTemplateObject.update( SQL, company.getCompany(), company.getEmail());
        System.out.println(SQL);
    }
    
    public Customer findByCustomerId(Integer id) {
        String SQL = "select * from CUSTOMER where id = ?";
        Customer customer = (Customer)jdbcTemplateObject.queryForObject(SQL, 
           new Object[]{id}, new StudentMapper());
        System.out.println(SQL);    
        return customer;
    }
    
    public List<Company> listCustomers() {
        String SQL = "select * from CUSTOMER";
        List <Company> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        System.out.println(SQL);
        return students;
    }
    
    public void delete(Integer id) {
        String SQL = "delete from CUSTOMER where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
    }
    
    public void update(Integer id, Integer email){
        String SQL = "update CUSTOMER set NAME = ? where id = ?";
        jdbcTemplateObject.update(SQL, email, id);
        System.out.println("Updated Record with ID = " + id );
    }
}
