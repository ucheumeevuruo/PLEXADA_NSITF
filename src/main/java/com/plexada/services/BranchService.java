/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.doa.BranchMapper;
import com.plexada.domain.Branch;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SAP Training
 */
public class BranchService {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }

   public List<Branch> findByObjectId(int regionId) {
        String SQL = "select branch_id, region_id, name from branch where region_id = ? order by branch_id desc";
        List<Branch> branch = jdbcTemplateObject.query(SQL, 
           new Object[]{regionId}, new BranchMapper());
        System.out.println(SQL);    
        return branch;
    }

    //@Override
    public List<Branch> findAll() {
        String SQL = "select * from branch order by branch_id desc";
        List <Branch> branch = jdbcTemplateObject.query(SQL, new BranchMapper());
        System.out.println(SQL);
        return branch;
    }

    public int findTotalCustomer() {
        String SQL = "select count(*) from branch order by branch_id desc";
        List <Branch> branch = jdbcTemplateObject.query(SQL, new BranchMapper());
        System.out.println(SQL);
        return branch.size();
    }
}
