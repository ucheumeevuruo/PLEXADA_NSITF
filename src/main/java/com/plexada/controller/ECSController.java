/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.build.Emulment;
import com.plexada.build.NavLinks;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private final String header = "ECS";
    
    @GetMapping("/dashboard")
    public String home(Model model){
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        path = "ECS-Dashboard";
        return this.path;
    }
    
    @GetMapping("/notification-type")
    public String showNotification(@PathVariable String path, Model model){
        this.path = "ECS-Notification";
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        return this.path;
    }
    
    @PostMapping("/notification-type/{path}")
    public String postNotificationForm(@PathVariable String path, Model model){
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
    
    @GetMapping("/subscription")
    public String showSubscription(Model model){
        this.path = "ECS-Subscription";
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        //model.addAttribute("subscription", links.ECSSidebarLinks());
        return this.path;
    }
    
    @PostMapping("/subscription")
    public String postSubscriptionForm(Model model,  
    @ModelAttribute @Valid Emulment emulment, 
    BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            //Redirect to next page
            //this.path = "redirect:/account/third-page";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        //model.addAttribute("subscription", emulment);
        this.path = "ECS-Subscription";
        return this.path;
    }
    
    @GetMapping("/change-password")
    public String showChangePassword(Model model){
        this.path = "ECS-Change-Password";
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        return this.path;
    }
    
    @PostMapping("/change-password")
    public String postChangePasswordForm(Model model,  
    @ModelAttribute @Valid Emulment emulment, 
    BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            //Redirect to next page
            //this.path = "redirect:/account/third-page";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links.ECSSidebarLinks());
        //model.addAttribute("subscription", emulment);
        this.path = "ECS-Change-Password";
        return this.path;
    }
}
