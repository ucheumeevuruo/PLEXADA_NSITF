/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.plexada.model.registration.LoginModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SAP Training
 */
public class LoginMapper implements RowMapper {
    
    public LoginMapper () {
    }
    
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        LoginModel login = new LoginModel();
        login.setId(rs.getString("ID"));
        login.setUsername(rs.getString("USERNAME"));
        login.setPassword(rs.getString("PASSWORD"));
        return login;
    }
    
}
