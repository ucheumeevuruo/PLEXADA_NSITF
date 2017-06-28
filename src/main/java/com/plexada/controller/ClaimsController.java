/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/ecs")
public class ClaimsController {
    //
    @GetMapping("")
    public String home(){
        return "ECS-Dashboard";
    }
    
    @GetMapping("/notification")
    public String Notification(){
        return "ECS-Notification";
    }
    
    @GetMapping("/compentation")
    public String Compensation(){
        return "ECS-Compentation";
    }
    
    @GetMapping("/subscription")
    public String Subscription(){
        return "ECS-Subscription";
    }
    
    @GetMapping("/change-password")
    public String ChangePassword(){
        return "ECS-Change-Password";
    }
}
