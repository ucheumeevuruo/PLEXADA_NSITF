/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import com.plexada.build.HashAlgorithm;
import com.plexada.build.Link;
import com.plexada.build.NavLinks;
import com.plexada.doa.JsonDBRepository;
import com.plexada.model.Cookie;
import com.plexada.model.registration.Accident;
import com.plexada.model.registration.Disease;
import com.plexada.model.registration.ClaimEmployee;
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
import com.plexada.services.ProvinceService;
import com.plexada.services.StateService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/notification")
public class ODController {
    List<Link> links;
    private final String header = "Notification of Accident/ Occupational Disease/ Death";
    private String path;
    private JsonDBRepository repo = null;
    Type collectionType = new TypeToken<Map<String, Object>>(){}.getType();
    private final ObjectMapper mapper = new ObjectMapper();
    private Map<String, Object> map = new HashMap();
    private final Cookie cookie = new Cookie();
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

    StateService state = (StateService) context.getBean("stateDAO");
    ProvinceService local = (ProvinceService) context.getBean("localDAO");
    
    private void setCookieRequest(HttpServletRequest http, String name){
        cookie.setIpAddress(http.getRemoteHost());
        cookie.setHashed(HashAlgorithm.hashingUsingCommons(http.getRemoteHost() + http.getHeader("User-Agent")));
        cookie.setName(name);
    }
    
    @GetMapping("/{type}/employee")
    public String showEmployeeForm(Model model,
    @PathVariable String type, 
    HttpServletRequest request){
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.occupationSidebarLinks();
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
        }else{
            this.path = "redirect:/notification";
        }
        ClaimEmployee claims;
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, type);
            repo = new JsonDBRepository(cookie);    
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                claims = new ClaimEmployee();    
            }else{
                claims = mapper.convertValue(repo.findAll().get("employee"), ClaimEmployee.class);
            }
            System.out.println(repo.findAll().toString());
        } catch (Exception ex) {
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
    BindingResult bindingResult,
    HttpServletRequest request) throws Exception{
        this.path = "notification/employee";
        String redirect = "";
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.occupationSidebarLinks();
            redirect = type + "/disease";
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
            redirect = type + "/accident";
        }else{
            this.path = "redirect:/notification";
        }
        
        //Validate the script before we move on
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, type);
            repo = new JsonDBRepository(cookie); 
            map = new HashMap();
            map.put("employee", claim);
            repo.save(map);
            this.path = "redirect:/notification/" + redirect;
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", claim);
        return this.path;
    }
    
    @GetMapping("/accident/accident")
    public String showAccidentForm(Model model,
    HttpServletRequest request){
        this.path = "notification/accident";
        links = NavLinks.accidentSidebarLinks();
        
        Accident accident = new Accident();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, "accident");
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                this.path = "redirect:/notification/accident/employee";
            }else if(repo.contains("accident")){
                accident = mapper.convertValue(repo.findAll().get("accident"), Accident.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/notification/accident/employee";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", accident);
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findByObjectId(0));
        return this.path;
    }
    
    @PostMapping("/accident/accident")
    public String postAccidentForm(Model model,
    @ModelAttribute Accident accident,
    BindingResult bindingResult,
    HttpServletRequest request){
        this.path = "notification/accident";
        links = NavLinks.accidentSidebarLinks();
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, "accident");
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("accident", accident);
            repo.save(map);
            this.path = "redirect:/notification/accident/attestation";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", accident);
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findByObjectId(0));
        return this.path;
    }
    
    @GetMapping("/occupational-disease/disease")
    public String showDiseaseFrom(Model model,
    HttpServletRequest request){
        this.path = "notification/disease";
        links = NavLinks.occupationSidebarLinks();
        
        Disease disease = new Disease();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, "occupational-disease");
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                this.path = "redirect:/notification/occupational-disease/employee";
            }else if(repo.contains("disease")){
                disease = mapper.convertValue(repo.findAll().get("disease"), Disease.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/notification/occupational-disease/employee";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", disease);
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findByObjectId(0));
        return this.path;
    }
    
    @PostMapping("/occupational-disease/disease")
    public String postDiseaseForm(Model model,
    @ModelAttribute @Valid Disease disease,
    BindingResult bindingResult,
    HttpServletRequest request){
        this.path = "notification/disease";
        links = NavLinks.occupationSidebarLinks();
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, "occupational-disease");
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("disease", disease);
            repo.save(map);
            this.path = "redirect:/notification/occupational-disease/attestation";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", disease);
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findByObjectId(0));
        return this.path;
    }
    
    @GetMapping("/{type}/attestation")
    public String AttestationForm(Model model,
    @PathVariable String type,
    HttpServletRequest request){
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
            setCookieRequest(request, type);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                this.path = "redirect:/notification/accident/employee";
            }else if(repo.contains("attestation")){
                attestation = mapper.convertValue(repo.findAll().get("attestation"), NODAttestation.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/notification/accident/employee";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", attestation);
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findByObjectId(0));
        return this.path;
    }
    
    @PostMapping("/{type}/attestation")
    public String Attestation(Model model,
    @PathVariable String type, 
    @ModelAttribute @Valid NODAttestation attestation,
    @RequestParam("signature") MultipartFile signature,
    @RequestParam("stamp") MultipartFile stamp,
    BindingResult bindingResult,
    HttpServletRequest request){
        this.path = "notification/attestation";
        if(type.equalsIgnoreCase("occupational-disease")){
            links = NavLinks.occupationSidebarLinks();
        }else if(type.equalsIgnoreCase("accident")){
            links = NavLinks.accidentSidebarLinks();
        }else{
            this.path = "redirect:/notification";
        }
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, type);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            repo.save(map);
            this.path = "redirect:/notification/" + type + "/finish";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", attestation);
        return this.path;
    }
    
    @GetMapping("/{type}/finish")
    public String finish(Model model,
    @PathVariable String type,
    HttpServletRequest request){
        this.path = "finish";
        Map<String, Object> progress = new HashMap();
        progress.put("response", "success");
        progress.put("message", "Registration successful!");
        setCookieRequest(request, type);
        repo = new JsonDBRepository(cookie);  
        repo.delete();
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("progress", progress);
        return this.path;
    }
}
