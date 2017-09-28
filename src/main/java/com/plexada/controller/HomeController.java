/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.domain.Company;
import com.plexada.build.Link;
import com.plexada.build.NavLinks;
import com.plexada.services.StateService;
import com.plexada.siebel.service.CompanyService;
import com.siebel.data.SiebelException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SAP Training
 */
    @Controller
    @RequestMapping("/home")
        public class HomeController {
        List<Link> links = NavLinks.HomeSidebarLinks();
        
    private String path;
    private final String header = "HOME";
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    
    //Cookie customerDAO = (Cookie) context.getBean("customerDAO");stateDAO
    CompanyService companyService = null;
    StateService state = (StateService) context.getBean("stateDAO");
    
    @GetMapping("")
    public String home(Model model){
        
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        path = "ECS-Home";
        return this.path;
    }
    
    @GetMapping("/search")
    public String showSearch(Model model){
        this.path = "ECS-Search";
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        return this.path;
    }
    
    @PostMapping("/search")
    public String postSearchForm(Model model,  
    @RequestParam("q") String q) throws SiebelException{
        List<Link> list = new ArrayList();
        Link link = new Link();
        List<Company> searchResult = companyService.find(q);
        for (Iterator<Company> companies = searchResult.iterator(); companies.hasNext();) {
            Company company = companies.next();
            link.setHref("/ecs/dashboard/" + company.getId());
            link.setValue((String)company.getIncNumber());
            list.add(link);
        }
        //Redirect to next page
        //this.path = "redirect:/account/third-page";
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("results", list);
        this.path = "ECS-Search";
        return this.path;
    }
    
}
