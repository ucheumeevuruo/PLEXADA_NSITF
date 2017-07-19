/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.google.gson.Gson;
import com.plexada.services.BranchService;
import com.plexada.services.ProvinceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SAP Training
 */
@RestController
public class AjaxRequestController {
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    ProvinceService local = (ProvinceService) context.getBean("localDAO");
    BranchService branch = (BranchService) context.getBean("branchDAO");
    private final Gson gson = new Gson();
    
    @RequestMapping("/locale/ng/{state_id}")
    public String localRequest(@PathVariable Integer state_id){
        return  gson.toJson(local.findByObjectId(state_id));
    }
    
    @RequestMapping("/locale/rg/{branch_id}")
    public String branchRequest(@PathVariable Integer branch_id){
        return  gson.toJson(branch.findByObjectId(branch_id));
    }
}
