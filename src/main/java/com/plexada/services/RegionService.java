/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.doa.RegionMapper;
import com.plexada.domain.Regions;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SAP Training
 */
public class RegionService {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }
    
    public Regions findByObjectId(int Id) {
        String SQL = "select region_id, name from regions where region_id = ?";
        Regions region = (Regions)jdbcTemplateObject.queryForObject(SQL, 
           new Object[]{Id}, new RegionMapper());
        System.out.println(SQL);    
        return region;
    }
    
    public List<Regions> findAll() {
        String SQL = "select region_id, name from regions";
        List <Regions> region = jdbcTemplateObject.query(SQL, new RegionMapper());
        System.out.println(SQL);
        return region;
    }
    
    public int findTotalCustomer() {
        String SQL = "select count(region_id) from regions";
        List <Regions> region = jdbcTemplateObject.query(SQL, new RegionMapper());
        System.out.println(SQL);
        return region.size();
    }
    
}
