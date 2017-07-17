/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.doa.LocalMapper;
import com.plexada.model.Locals;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SAP Training
 */
public class ProvinceService{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }

    public List<Locals> findByObjectId(int stateId) {
        String SQL = "select local_id, state_id, local_name from locals where state_id = ? order by local_name asc";
        List<Locals> local = jdbcTemplateObject.query(SQL, 
           new Object[]{stateId}, new LocalMapper());
        System.out.println(SQL);    
        return local;
    }

    //@Override
    public List<Locals> findAll() {
        String SQL = "select * from locals order by local_name asc";
        List <Locals> local = jdbcTemplateObject.query(SQL, new LocalMapper());
        System.out.println(SQL);
        return local;
    }

    public int findTotalCustomer() {
        String SQL = "select count(*) from locals order by local_name asc";
        List <Locals> local = jdbcTemplateObject.query(SQL, new LocalMapper());
        System.out.println(SQL);
        return local.size();
    }
}
