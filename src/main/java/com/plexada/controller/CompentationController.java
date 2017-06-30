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
import com.plexada.model.registration.Attestation;
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
import com.plexada.model.registration.Treatment;
import com.plexada.model.registration.Upload;
import com.plexada.services.ProvinceService;
import com.plexada.services.StateService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/compensation")
public class CompentationController {
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
    private final String name = "compentation-employee";
    
    private void setCookieRequest(HttpServletRequest http, String name){
        cookie.setIpAddress(http.getRemoteHost());
        cookie.setHashed(HashAlgorithm.hashingUsingCommons(http.getRemoteHost() + http.getHeader("User-Agent")));
        cookie.setName(name);
    }
    
    @GetMapping("/step1")
    public String showEmployeeDetailsForm(Model model,
    HttpServletRequest request){
        // The model the for will use
        // Use the correct model here and in the post method
        ClaimEmployee claims;
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);    
            repo.initRepo(collectionType);
            // If employee is not a member of the map use the default object
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
        return "compentation/employee";
    }
    
    @PostMapping("/step1")
    public String postEmployeeDetailsForm(Model model, 
    @PathVariable String type, 
    @ModelAttribute @Valid ClaimEmployee claim, 
    BindingResult bindingResult,
    HttpServletRequest request) throws Exception{
        // The template to display
        // Path reperesents the template to resolve to
        this.path = "compentation/employee";
        
        //Validate the script before we move on
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie); 
            map = new HashMap();
            map.put("employee", claim);
            repo.save(map);
            // Redirect to the next step
            this.path = "redirect:/compentation/step2";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", claim);
        return this.path;
    }
    
    @GetMapping("/step2")
    public String showHealthProviderForm(Model model,
    HttpServletRequest request){
        this.path = "compentation/provider";
        links = NavLinks.accidentSidebarLinks();
        
        Accident accident = new Accident();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compentation/step1";
            }else if(repo.contains("provider")){
                accident = mapper.convertValue(repo.findAll().get("provider"), Accident.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/compentation/step1";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", accident);
        return this.path;
    }
    
    @PostMapping("/step2")
    public String postHealthProviderForm(Model model,
    @ModelAttribute Accident accident,
    BindingResult bindingResult,
    HttpServletRequest request){
        this.path = "compentation/provider";
        links = NavLinks.accidentSidebarLinks();
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("provider", accident);
            repo.save(map);
            this.path = "redirect:/compentation/step3";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", accident);
        return this.path;
    }
    
    @GetMapping("/step3")
    public String showDetailOfTreatmentForm(Model model,
    HttpServletRequest request){
        this.path = "compentation/bill";
        links = NavLinks.accidentSidebarLinks();
        
        Treatment treatment = new Treatment();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compentation/step1";
            }else if(!repo.contains("provider")){
                this.path = "redirect:/compentation/step2";
            }else if(repo.contains("bill")){
                treatment = mapper.convertValue(repo.findAll().get("bill"), Treatment.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/compentation/step2";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", treatment);
        return this.path;   
    }
    
    @PostMapping("/step3")
    public String postDetailOfTreatmentForm(Model model,
    @ModelAttribute Treatment treatment,
    BindingResult bindingResult,
    HttpServletRequest request){
        this.path = "compentation/bill";
        links = NavLinks.accidentSidebarLinks();
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("bill", treatment);
            repo.save(map);
            this.path = "redirect:/compentation/step4";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", treatment);
        return this.path;
    }
    
    @GetMapping("/step4")
    public String showAttachmentForm(Model model,
    HttpServletRequest request){
        this.path = "compentation/attachment";
        links = NavLinks.accidentSidebarLinks();
        
        Upload upload = new Upload();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compentation/step1";
            }else if(!repo.contains("provider")){
                this.path = "redirect:/compentation/step2";
            }else if(!repo.contains("bill")){
                this.path = "redirect:/compentation/step3";
            }else if(repo.contains("upload")){
                upload = mapper.convertValue(repo.findAll().get("upload"), Upload.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/compentation/step3";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", upload);
        return this.path;
    }
    
    @PostMapping("/step4")
    public String postAttachmentForm(Model model,
    @ModelAttribute Upload upload,
    BindingResult bindingResult,
    HttpServletRequest request){
        this.path = "compentation/attachment";
        links = NavLinks.accidentSidebarLinks();
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("attachment", upload);
            repo.save(map);
            this.path = "redirect:/compentation/step5";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", upload);
        return this.path;
    }
    
    @GetMapping("/step5")
    public String showBankAndAttestationForm(Model model,
    HttpServletRequest request){
        this.path = "compentation/bank";
        links = NavLinks.accidentSidebarLinks();
        
        Attestation attestation = new Attestation();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compentation/step1";
            }else if(!repo.contains("provider")){
                this.path = "redirect:/compentation/step2";
            }else if(!repo.contains("bill")){
                this.path = "redirect:/compentation/step3";
                }else if(!repo.contains("upload")){
                this.path = "redirect:/compentation/step4";
            }else if(repo.contains("attachment")){
                attestation = mapper.convertValue(repo.findAll().get("attestation"), Attestation.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/compentation/step4";
             }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", attestation);
        return this.path;
    }
    
    @PostMapping("/step5")
    public String postBankAndAttestationForm(Model model,
    @ModelAttribute Attestation attestation,
    BindingResult bindingResult,
    HttpServletRequest request){
        this.path = "compentation/bank";
        links = NavLinks.accidentSidebarLinks();
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("bank", attestation);
            repo.save(map);
            this.path = "redirect:/compentation/finish";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", attestation);
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findAll());
        return this.path;
    }
    
    @GetMapping("/{path}/finish")
    public String finish(@PathVariable String path,
    HttpServletRequest request){
        links = NavLinks.accidentSidebarLinks();
        setCookieRequest(request, path);
        repo = new JsonDBRepository(cookie); 
        
        Attestation attestation = new Attestation();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employee")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compentation/step1";
            }else if(!repo.contains("provider")){
                this.path = "redirect:/compentation/step2";
            }else if(!repo.contains("bill")){
                this.path = "redirect:/compentation/step3";
            }else if(!repo.contains("upload")){
                this.path = "redirect:/compentation/step4";
            }else if(!repo.contains("attachment")){
                this.path = "redirect:/compentation/step5";
                //attestation = mapper.convertValue(repo.findAll().get("attestation"), Attestation.class);
            }else{
                // Save and delete cached form fromrepository
                this.path = "redirect:/ecs/subscription";
                repo.delete();
            }
        } catch (Exception ex) {
            this.path = "redirect:/compentation/step5";
        }
        return this.path;
    }    
        
    }
