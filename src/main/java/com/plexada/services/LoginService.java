/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.doa.LoginMapper;
import com.plexada.model.registration.LoginModel;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SAP Training
 */
public class LoginService {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }
    
    public LoginModel login(LoginModel user) {
        String SQL = "select username, password, id from users where username = ? and password = ?";
        List<LoginModel> login = jdbcTemplateObject.query(SQL, 
           new Object[]{user.getUsername(), user.getPassword()}, new LoginMapper());
        System.out.println(SQL);    
        return (login.size() > 0) ? login.get(0) : null;
    }
    
    
}
