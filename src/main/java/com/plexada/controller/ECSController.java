/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.build.NavLinks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/ecs")
public class ECSController {
    NavLinks links = new NavLinks();
    private String path;
    private final String header = "";
    
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        path = "ECS-Dashboard";
        return this.path;
    }
    
    @GetMapping("/notification-type/{path}")
    public String notification(@PathVariable String path, Model model){
        if(path.equalsIgnoreCase("accident")){
            this.path = "redirect:/notification/" + path;
        }else if(path.equalsIgnoreCase("disease")){
            this.path = "redirect:/notification/occupational-disease";
        }else{
            this.path = "ECS-Notification";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        return this.path;
    }
    
    @GetMapping("/compentation")
    public String compensation(Model model){
        this.path = "ECS-Compentation";
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        return this.path;
    }
    
    @GetMapping("/subscription")
    public String subscription(Model model){
        this.path = "ECS-Subscription";
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        return this.path;
    }
    
    @GetMapping("/change-password")
    public String ChangePassword(Model model){
        this.path = "ECS-Change-Password";
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        return this.path;
    }
}
