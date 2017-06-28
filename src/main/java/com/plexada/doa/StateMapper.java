/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.plexada.model.States;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SAP Training
 */
public class StateMapper implements RowMapper {

    public StateMapper() {
    }
    
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        States state = new States();
        state.setId(rs.getInt("STATE_ID"));
        state.setName(rs.getString("NAME"));
        return state;
    }
}
