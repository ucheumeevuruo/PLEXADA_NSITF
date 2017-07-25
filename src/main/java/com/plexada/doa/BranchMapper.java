/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.plexada.model.Branch;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SAP Training
 */
public class BranchMapper implements RowMapper {
    
   public BranchMapper() {
    }
    
     @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Branch branch = new Branch();
        branch.setId(rs.getInt("BRANCH_ID"));
        branch.setRegionId(rs.getInt("REGION_ID"));
        branch.setName(rs.getString("NAME"));
        return branch;
    }
    
}
