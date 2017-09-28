/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.plexada.domain.Regions;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SAP Training
 */
public class RegionMapper implements RowMapper {
    
    public RegionMapper() {
    }
    
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Regions region = new Regions();
        region.setId(rs.getInt("REGION_ID"));
        region.setName(rs.getString("NAME"));
        return region;
    }
}
