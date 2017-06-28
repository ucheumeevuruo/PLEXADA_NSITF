/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.doa.StateMapper;
import com.plexada.model.States;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SAP Training
 */
public class StateService{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }

    public States findByObjectId(int Id) {
        String SQL = "select state_id, name from states where state_id = ?";
        States state = (States)jdbcTemplateObject.queryForObject(SQL, 
           new Object[]{Id}, new StateMapper());
        System.out.println(SQL);    
        return state;
    }

    //@Override
    public List<States> findAll() {
        String SQL = "select state_id, name from states";
        List <States> state = jdbcTemplateObject.query(SQL, new StateMapper());
        System.out.println(SQL);
        return state;
    }

    public int findTotalCustomer() {
        String SQL = "select count(state_id) from states";
        List <States> state = jdbcTemplateObject.query(SQL, new StateMapper());
        System.out.println(SQL);
        return state.size();
    }
}
