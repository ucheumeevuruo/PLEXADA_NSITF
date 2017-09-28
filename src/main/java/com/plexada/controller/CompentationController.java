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
import com.plexada.domain.Cookie;
import com.plexada.model.registration.Accident;
import com.plexada.model.registration.Attestation;
import com.plexada.model.registration.ClaimEmployee;
import com.plexada.model.registration.Employer;
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
import com.plexada.model.registration.Treatment;
import com.plexada.model.registration.Upload;
import com.plexada.model.registration.healthModel;
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
    private final String name = "compensation-employee";

    public CompentationController() {
        this.links = NavLinks.claimsSidebarLink();
    }
    
    private void setCookieRequest(HttpServletRequest http, String name){
        cookie.setIpAddress(http.getRemoteHost());
        cookie.setHashed(HashAlgorithm.hashingUsingCommons(http.getRemoteHost() + http.getHeader("User-Agent")));
        cookie.setName(name);
    }
    
    @GetMapping("/step1")
    public String showEmployerDetailsForm(Model model,
    HttpServletRequest request){
        // The model the for will use
        // Use the correct model here and in the post method
        this.path = "compensation/employer-details";
        Employer employer;
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);    
            repo.initRepo(collectionType);
            // If employee is not a member of the map use the default object
            if(!repo.contains("employer")){
                employer = new Employer();    
            }else{
                employer = mapper.convertValue(repo.findAll().get("employer"), Employer.class);
            }
            System.out.println(repo.findAll().toString());
        } catch (Exception ex) {
            employer = new Employer();
        }

        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", employer);
        return this.path;
    }
    
    @PostMapping("/step1")
    public String postEmployerDetailsForm(Model model, 
    @ModelAttribute @Valid Employer employer, 
    BindingResult bindingResult,
    HttpServletRequest request) throws Exception{
        // The template to display
        // Path reperesents the template to resolve to
        this.path = "compensation/employer-details";
        
        //Validate the script before we move on
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie); 
            map = new HashMap();
            map.put("employer", employer);
            repo.save(map);
            // Redirect to the next step
            this.path = "redirect:/compensation/step2";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", employer);
        System.out.println(bindingResult.getAllErrors());
        return this.path;
    }
    
    @GetMapping("/step2")
    public String showHealthProviderForm(Model model,
    HttpServletRequest request){
        this.path = "compensation/health-status";
        
        healthModel provider = new healthModel();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employer")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compensation/step1";
            }else if(repo.contains("provider")){
                provider = mapper.convertValue(repo.findAll().get("provider"), healthModel.class);
            }
            System.out.println(repo.findAll().toString());
        } catch (Exception ex) {
            this.path = "redirect:/compensation/step1";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", provider);
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findAll());
        return this.path;
    }
    
    @PostMapping("/step2")
    public String postHealthProviderForm(Model model,
    @ModelAttribute healthModel provider,
    BindingResult bindingResult,
    HttpServletRequest request){
        this.path = "compensation/health-status";
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("provider", provider);
            repo.save(map);
            this.path = "redirect:/compensation/step3";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", provider);
        return this.path;
    }
    
    @GetMapping("/step3")
    public String showDetailOfTreatmentForm(Model model,
    HttpServletRequest request){
        this.path = "compensation/treatment-bill";
        
        Treatment treatment = new Treatment();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employer")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compensation/step1";
            }else if(!repo.contains("provider")){
                this.path = "redirect:/compensation/step2";
            }else if(repo.contains("bill")){
                treatment = mapper.convertValue(repo.findAll().get("bill"), Treatment.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/compensation/step2";
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
        this.path = "compensation/treatment-bill";
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("bill", treatment);
            repo.save(map);
            this.path = "redirect:/compensation/step4";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", treatment);
        System.out.println(bindingResult.getAllErrors());
        return this.path;
    }
    
    @GetMapping("/step4")
    public String showAttachmentForm(Model model,
    HttpServletRequest request){
        this.path = "compensation/attachment";
        
        Upload upload = new Upload();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employer")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compensation/step1";
            }else if(!repo.contains("provider")){
                this.path = "redirect:/compensation/step2";
            }else if(!repo.contains("bill")){
                this.path = "redirect:/compensation/step3";
            }else if(repo.contains("upload")){
                upload = mapper.convertValue(repo.findAll().get("upload"), Upload.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/compensation/step3";
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
        this.path = "compensation/attachment";
        
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("upload", upload);
            repo.save(map);
            this.path = "redirect:/compensation/step5";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", upload);
        return this.path;
    }
    
    @GetMapping("/step5")
    public String showBankAndAttestationForm(Model model,
    HttpServletRequest request){
        this.path = "compensation/bank-details";
        
        Attestation attestation = new Attestation();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employer")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compensation/step1";
            }else if(!repo.contains("provider")){
                this.path = "redirect:/compensation/step2";
            }else if(!repo.contains("bill")){
                this.path = "redirect:/compensation/step3";
            }else if(!repo.contains("upload")){
                this.path = "redirect:/compensation/step4";
            }else if(repo.contains("attestation")){
                attestation = mapper.convertValue(repo.findAll().get("attestation"), Attestation.class);
            }
        } catch (Exception ex) {
            this.path = "redirect:/compensation/step4";
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
        this.path = "compensation/bank-details";
        
        if(!bindingResult.hasErrors()){
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            map = new HashMap();
            map.put("attestation", attestation);
            repo.save(map);
            this.path = "redirect:/compensation/finish";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("var", attestation);
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findAll());
        return this.path;
    }
    
    @GetMapping("/finish")
    public String finish(Model model,
    HttpServletRequest request){
        
        Map<String, Object> progress = new HashMap();
        Attestation attestation = new Attestation();
        try {
            // 1. JSON to Java object, read it from a file.
            setCookieRequest(request, name);
            repo = new JsonDBRepository(cookie);  
            repo.initRepo(collectionType);
            if(!repo.contains("employer")){
                // Redirect to step one if not exist in the list
                this.path = "redirect:/compensation/step1";
            }else if(!repo.contains("provider")){
                this.path = "redirect:/compensation/step2";
            }else if(!repo.contains("bill")){
                this.path = "redirect:/compensation/step3";
            }else if(!repo.contains("upload")){
                this.path = "redirect:/compensation/step4";
            }else if(!repo.contains("attachment")){
                this.path = "redirect:/compensation/step5";
                //attestation = mapper.convertValue(repo.findAll().get("attestation"), Attestation.class);
            }else{
                // Save and delete cached form fromrepository
                this.path = "redirect:/ecs/subscription";
                // repo.delete();
            }
        } catch (Exception ex) {
            //this.path = "redirect:/compensation/step5";
        }
        progress.put("response", "success");
        progress.put("message", "Registration successful!");
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("progress", progress);
        return this.path;
    }    
}
