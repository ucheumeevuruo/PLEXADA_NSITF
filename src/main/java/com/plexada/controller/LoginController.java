/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.build.Link;
import com.plexada.build.NavLinks;
import com.plexada.model.registration.LoginModel;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping ("/ecs")
public class LoginController {
     List<Link> links = NavLinks.ECSSidebarLinks();
    private String path;
    private final String header = "ECS";
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    
    @GetMapping ("/login")
    public String showLoginForm(Model model) {
 
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        path = "ECS-Login";
        return this.path;
    }
    
    @PostMapping
    public String postLogoinForm (Model model,
        @ModelAttribute LoginModel loginModel) {
        if (loginModel != null && loginModel.getUsername() != null & loginModel.getPassword() != null) {
            
        } else {
            model.addAttribute("error", "Please enter Details");
            return "/login";
        }
         return "redirect:/ecs/dashboard";
    }
        
        
    }
    
     

