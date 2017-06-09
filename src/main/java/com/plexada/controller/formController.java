/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.model.Employees;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping(path = "/account")
public class formController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        Employees emp = new Employees();
        emp.setId(05);
        return new ModelAndView("home", "employee", emp);
    }
    
    @RequestMapping(value = "/second-page", method = RequestMethod.POST)
    public ModelAndView showStaffEmulmentForm() {
        return new ModelAndView("staffEmulment", "employee", new Employees());
    }
    
    @RequestMapping(value = "/third-page", method = RequestMethod.POST)
    public ModelAndView showBusinessClassForm() {
        return new ModelAndView("businessClass", "employee", new Employees());
    }
    
    @RequestMapping(value = "/fourth-page", method = RequestMethod.POST)
    public ModelAndView showOwnersParticularForm() {
        return new ModelAndView("ownersParticular", "employee", new Employees());
    }
    
    @RequestMapping(value = "/fifth-page", method = RequestMethod.POST)
    public ModelAndView showStaffInfoForm() {
        return new ModelAndView("staffInfo", "employee", new Employees());
    }
}
