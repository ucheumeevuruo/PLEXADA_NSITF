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
        String SQL = "INSERT INTO pre_registrations(id, ip_addr, ses_document) values (?, ?, ?)";
        jdbcTemplateObject.update( SQL, '1', cookie.getIp_address(), String.valueOf(cookie.getJsonDoc()));
        System.out.println(SQL + " " + cookie.getJsonDoc());
    }
    
    public Cookie findByCustomerId(String id) {
        String SQL = "select * from pre_registrations where id = ?";
        Cookie cookie = (Cookie)jdbcTemplateObject.queryForObject(SQL, 
           new Object[]{id}, new CookieMapper());
        System.out.println(SQL);    
        return cookie;
    }
    
    public List<Cookie> findById(String id) {
        String SQL = "select * from pre_registrations where id = ?";
        List<Cookie> cookie = jdbcTemplateObject.query(SQL, 
           new Object[]{id}, new CookieMapper());
        System.out.println(SQL);    
        return cookie;
    }
    
    public List<Cookie> listCustomers() {
        String SQL = "select * from pre_registrations";
        List <Cookie> cookie = jdbcTemplateObject.query(SQL, new CookieMapper());
        System.out.println(SQL);
        return cookie;
    }
    
    public void delete(Integer id) {
        String SQL = "delete from pre_registrations where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
    }
    
    public void update(Cookie cookie){
        String SQL = "update pre_registrations set ses_document = ? where ip_addr = ?";
        jdbcTemplateObject.update(SQL, cookie.getJsonDoc(), cookie.getIp_address());
        System.out.println("Updated Record with ID = " + cookie.getId() );
    }
}
