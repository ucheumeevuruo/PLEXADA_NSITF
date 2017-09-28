/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.domain.Cookie;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SAP Training
 */
public class CookieMapper implements RowMapper {

    public CookieMapper() {
    }

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Cookie cookie = new Cookie();
        cookie.setId(rs.getInt("ID"));
        cookie.setIpAddress(rs.getString("ip_addr"));
        cookie.setJsonDoc(rs.getString("ses_document"));
        return cookie;
    }
    
}
