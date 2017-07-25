/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SAP Training
 */
public class CompanyMapper implements RowMapper {

    public CompanyMapper() {
        
    }
//name, rc_number, email, mobile_number, state, province, block_no, street_address, owner, position
    @Override
    public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
        Map<String, Object> map = new HashMap();
        map.put("id", rs.getInt("ID"));
        map.put("name", rs.getString("name"));
        map.put("rc_number", rs.getString("rc_number"));
        map.put("email", rs.getString("email"));
        map.put("mobile_number", rs.getString("mobile_number"));
        map.put("state", rs.getString("state"));
        map.put("province", rs.getString("province"));
        map.put("block_no", rs.getString("block_no"));
        map.put("street_address", rs.getString("street_address"));
        map.put("owner", rs.getString("owner"));
        map.put("position", rs.getString("position"));
        return map;
    }
    
}
