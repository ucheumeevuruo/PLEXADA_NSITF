/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.plexada.model.Locals;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SAP Training
 */
public class LocalMapper implements RowMapper {

    public LocalMapper() {
    }
    
     @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Locals local = new Locals();
        local.setId(rs.getInt("LOCAL_ID"));
        local.setStateId(rs.getInt("STATE_ID"));
        local.setName(rs.getString("LOCAL_NAME"));
        return local;
    }
}
