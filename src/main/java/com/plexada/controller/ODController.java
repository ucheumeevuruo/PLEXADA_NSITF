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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/notification/occupational-disease")
public class ODController {
    NavLinks links = new NavLinks();
    private final String header = "";
    
    @GetMapping("")
    public String detailsForm(Model model){
        model.addAttribute("header", header);
        model.addAttribute("links", links.notificationSidebarLinks());
        return "claims/od/employee";
    }
    
    @PostMapping("")
    public String details(Model model){
        model.addAttribute("header", header);
        model.addAttribute("links", links.notificationSidebarLinks());
        return "claims/od/employee";
    }
    
    @GetMapping("/accident")
    public String accidentForm(Model model){
        model.addAttribute("header", header);
        model.addAttribute("links", links.notificationSidebarLinks());
        return "claims/od/accident";
    }
    
    @PostMapping("/accident")
    public String accident(Model model){
        model.addAttribute("header", header);
        model.addAttribute("links", links.notificationSidebarLinks());
        return "claims/od/accident";
    }
    
    @GetMapping("/attestation")
    public String AttestationForm(Model model){
        model.addAttribute("header", header);
        model.addAttribute("links", links.notificationSidebarLinks());
        return "claims/od/attestation";
    }
    
    @PostMapping("/attestation")
    public String Attestation(Model model){
        model.addAttribute("header", header);
        model.addAttribute("links", links.notificationSidebarLinks());
        return "claims/od/attestation";
    }
}
