/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import com.plexada.build.Link;
import com.plexada.build.NavLinks;
import com.plexada.doa.JsonObjectRepository;
import com.plexada.model.registration.ClaimEmployee;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.plexada.model.registration.NoAAccident;
import com.plexada.model.registration.NODAttestation;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/notification")
public class ODController {
    List<Link> links;
    private final String header = "";
    private String path;
    private final JsonObjectRepository repo = new JsonObjectRepository();
    Type collectionType = new TypeToken<Map<String, Object>>(){}.getType();
    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<String, Object> map = new HashMap();
    
    @GetMapping("/{type}/employee")
    public String showEmployeeForm(Model model,
    @PathVariable String type){
        model.addAttribute("header", header);
        String contains = "";
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.accidentSidebarLinks();
            contains = "employeeD";
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.occupationSidebarLinks();
            contains = "employeeA";
        }
        ClaimEmployee claims;
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains(contains)){
                claims = new ClaimEmployee();    
            }else{
                claims = mapper.convertValue(repo.findAll().get(contains), ClaimEmployee.class);
            }
        } catch (IOException ex) {
            claims = new ClaimEmployee();
        }
            
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", claims);
        return "notification/employee";
    }
    
    @PostMapping("/{type}/employee")
    public String postEmployeeForm(Model model, 
    @ModelAttribute @Valid ClaimEmployee claim, 
    @PathVariable String type, 
    BindingResult bindingResult){
        this.path = "notification/employee";
        String redirect = "";
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.occupationSidebarLinks();
            redirect = type + "/accident";
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
            redirect = type + "/accident";
        }
        if(!bindingResult.hasErrors()){
            try {
                repo.save(map);
                this.path = "redirect:/notification/" + redirect;
            } catch (IOException ex) {}
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", claim);
        return this.path;
    }
    
    @GetMapping("/accident/accident")
    public String accidentForm(Model model){
        this.path = "notification/accident";
        links = NavLinks.accidentSidebarLinks();
        
        NoAAccident accident = new NoAAccident();
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("employeeA")){
                this.path = "redirect:/notification/accident/employee";    
            }else{
                accident = mapper.convertValue(repo.findAll().get("accident"), NoAAccident.class);
            }
        } catch (IOException ex) {}
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", accident);
        return this.path;
    }
    
    @PostMapping("/accident/accident")
    public String accident(Model model,
    @ModelAttribute @Valid NoAAccident accident,
    BindingResult bindingResult){
        this.path = "notification/accident";
        links = NavLinks.accidentSidebarLinks();
        if(!bindingResult.hasErrors()){
            try {
                repo.save(map);
                this.path = "redirect:/notification/accident/attestation";
            } catch (IOException ex) {}
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", accident);
        return this.path;
    }
    
    @GetMapping("/{type}/attestation")
    public String AttestationForm(Model model,
    @PathVariable String type){
        this.path = "notification/attestation";
        NODAttestation attestation = new NODAttestation();
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.occupationSidebarLinks();
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
        }
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("employeeA")){
                this.path = "redirect:/notification/accident/employee";    
            }else{
                attestation = mapper.convertValue(repo.findAll().get("attestation"), NODAttestation.class);
            }
        } catch (IOException ex) {}
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", attestation);
        return this.path;
    }
    
    @PostMapping("/attestation")
    public String Attestation(Model model,
    @PathVariable String type,
    @ModelAttribute @Valid NODAttestation attestation,
    BindingResult bindingResult){
        String redirect = "";
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.occupationSidebarLinks();
            redirect = type + "/accident";
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
            redirect = type + "/accident";
        }
        if(!bindingResult.hasErrors()){
            try {
                repo.save(map);
                this.path = "redirect:/notification/" + redirect;
            } catch (IOException ex) {}
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", attestation);
        return "notification/attestation";
    }
}
