/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.plexada.model.Cookie;

/**
 *
 * @author SAP Training
 */
public class DBCookieService {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }
    
    public void create(Cookie cookie) {
        String SQL = "INSERT INTO pre_registrations(id, ip_addr, ses_document, hashed, name) values (auto_increment.nextval, ?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, cookie.getIpAddress(), cookie.getJsonDoc(), cookie.getHashed(), cookie.getName());
        System.out.println(SQL + " " + cookie.getJsonDoc());
    }
    
    public Cookie findByCustomerId(String id) {
        String SQL = "select * from pre_registrations where id = ?";
        Cookie cookie = (Cookie)jdbcTemplateObject.queryForObject(SQL, 
           new Object[]{id}, new CookieMapper());
        System.out.println(SQL);    
        return cookie;
    }
    
    public List<Cookie> findByIP(Cookie cookie) {
        String SQL = "select * from pre_registrations where ip_addr = ? AND hashed = ? AND name = ?";
        List<Cookie> list = jdbcTemplateObject.query(SQL, 
           new Object[]{cookie.getIpAddress(), cookie.getHashed(), cookie.getName()}, new CookieMapper());
        System.out.println(SQL);    
        return list;
    }
    
    public List<Cookie> listCustomers() {
        String SQL = "select * from pre_registrations";
        List <Cookie> cookie = jdbcTemplateObject.query(SQL, new CookieMapper());
        System.out.println(SQL);
        return cookie;
    }
    
    public void delete(Cookie cookie) {
        String SQL = "delete from pre_registrations where ip_addr = ? AND  hashed = ? AND name = ?";
        jdbcTemplateObject.update(SQL, cookie.getIpAddress(), cookie.getHashed(), cookie.getName());
        System.out.println("Deleted Record with ID = " + cookie.getId() );
    }
    
    public void update(Cookie cookie){
        String SQL = "update pre_registrations set ses_document = ? where ip_addr = ? AND  hashed = ? AND name = ?";
        jdbcTemplateObject.update(SQL, cookie.getJsonDoc(), cookie.getIpAddress(), cookie.getHashed(), cookie.getName());
        System.out.println("Updated Record with ID = " + cookie.getId());
    }
    
    public int findTotalCustomer(Cookie cookie){
		
        String sql = "SELECT COUNT(ID) FROM pre_registrations where IP_ADDR = ? AND  HASHED = ? AND NAME = ?";

        Integer total = jdbcTemplateObject.queryForObject(sql, new Object[]{cookie.getIpAddress(), cookie.getHashed(), cookie.getName()}, Integer.class);

        return total;
    }
}
