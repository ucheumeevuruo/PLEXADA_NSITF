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
import com.plexada.model.registration.Accident;
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
import com.plexada.model.registration.NODAttestation;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/compentation")
public class CompentationController {
    List<Link> links;
    private final String header = "Notification of Accident/ Occupational Disease/ Death";
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
            links = NavLinks.occupationSidebarLinks();
            contains = "employeeD";
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
            contains = "employeeA";
        }else{
            this.path = "redirect:/notification";
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
    @PathVariable String type, 
    @ModelAttribute @Valid ClaimEmployee claim, 
    BindingResult bindingResult) throws Exception{
        this.path = "notification/employee";
        String redirect = "", contains = "";
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.occupationSidebarLinks();
            redirect = type + "/disease";
            contains = "employeeD";
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
            redirect = type + "/accident";
            contains = "employeeA";
        }else{
            this.path = "redirect:/notification";
        }
        
        //Validate the script before we move on
        if(!bindingResult.hasErrors()){
            try {
                map.put(contains, claim);
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
        
        Accident accident = new Accident();
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("employeeA")){
                this.path = "redirect:/notification/accident/employee";    
            }else{
                accident = mapper.convertValue(repo.findAll().get("accident"), Accident.class);
            }
        } catch (IOException ex) {}
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", accident);
        return this.path;
    }
    
    @PostMapping("/accident/accident")
    public String accident(Model model,
    @ModelAttribute @Valid Accident accident,
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
    
    @GetMapping("/occupational-disease/disease")
    public String showDiseaseFrom(Model model,
    BindingResult bindingResult){
        this.path = "notification/disease";
        links = NavLinks.accidentSidebarLinks();
        
        Accident disease = new Accident();
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("employeeD")){
                this.path = "redirect:/notification/occupational-disease/employee";    
            }else if(!repo.contains("disease")){
                disease = mapper.convertValue(repo.findAll().get("disease"), Accident.class);
            }
        } catch (IOException ex) {}
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", disease);
        return this.path;
    }
    
    @PostMapping("/occupational-disease/disease")
    public String postDiseaseForm(Model model,
    @ModelAttribute @Valid Accident disease,
    BindingResult bindingResult){
        this.path = "notification/disease";
        links = NavLinks.occupationSidebarLinks();
        if(!bindingResult.hasErrors()){
            try {
                map.put("disease", disease);
                repo.save(map);
                this.path = "redirect:/notification/occupational-disease/attestation";
            } catch (IOException ex) {}
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", disease);
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
        }else{
            this.path = "redirect:/notification";
        }
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("employeeA")){
                this.path = "redirect:/notification/accident/employee";    
            }else{
                if(repo.contains("attestation")){
                    attestation = mapper.convertValue(repo.findAll().get("attestation"), NODAttestation.class);
                }else{
                    this.path = "redirect:/notification/accident/employee";
                }
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
        this.path = "notification/attestation";
        String redirect = "";
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.occupationSidebarLinks();
            redirect = type + "/accident";
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
            redirect = type + "/accident";
        }else{
            this.path = "redirect:/notification";
        }
        if(!bindingResult.hasErrors()){
            try {
                repo.save(map);
                this.path = "redirect:/notification/finish";
            } catch (IOException ex) {}
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", attestation);
        return this.path;
    }
    
    @GetMapping("/finish")
    public String finish(){
        this.path = "notification/finish";
        return this.path;
    }
}
