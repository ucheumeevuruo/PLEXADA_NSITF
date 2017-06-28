/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import com.plexada.build.Company;
import com.plexada.build.Employee;
import com.plexada.build.Emulment;
import com.plexada.build.OwnersParticular;
import com.plexada.build.Sector;
import com.plexada.doa.JsonObjectRepository;
import com.plexada.model.States;
import com.plexada.services.AddressService;
import com.plexada.services.ProvinceService;
import com.plexada.services.StateService;
import java.io.FileNotFoundException;
import java.io.IOException;
//import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
//import org.apache.catalina.servlet4preview.ServletContext;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.plexada.build.NavLinks;

/**
 *
 * @author SAP Training 
 */
@Controller
@RequestMapping(path = "/account")
public class FormController {
    
    Type collectionType = new TypeToken<Map<String, Object>>(){}.getType();
    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<String, Object> map = new HashMap();
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

    //Cookie customerDAO = (Cookie) context.getBean("customerDAO");stateDAO
    StateService state = (StateService) context.getBean("stateDAO");
    ProvinceService local = (ProvinceService) context.getBean("localDAO");
    AddressService address = (AddressService)context.getBean("addressDAO");
    
    private final JsonObjectRepository repo = new JsonObjectRepository();
    
    private final NavLinks links = new NavLinks();
    private final String header = "REGISTRATION OF EMPLOYERS";
    
    @GetMapping("")
    public String index(HttpServletResponse response, 
    Model model) {
        Company company;
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("company")){
                company = new Company();    
            }else{
                company = mapper.convertValue(repo.findAll().get("company"), Company.class);
            }
        } catch (FileNotFoundException ex) {
            company = new Company();
        } catch (IOException | NullPointerException ex) {
            company = new Company();
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links.registrationSidebarLinks());
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findByObjectId(0));
        model.addAttribute("employee", company);
        return "home";
    }
    
    @PostMapping("")
    public String indexForm(HttpServletResponse response,
    Model model, 
    @ModelAttribute @Valid Company company, 
    BindingResult bindingResult) throws IOException, FileNotFoundException{
        if(bindingResult.hasErrors()){
            model.addAttribute("header", header);
            model.addAttribute("links", links.registrationSidebarLinks());
            model.addAttribute("states", state.findAll());
            model.addAttribute("locals", local.findByObjectId(0));
            model.addAttribute("employee", company);
            return "home";
        }
        //2. Convert object to JSON string and save into a file directly
        try {
            map.put("company", company);
            repo.save(map);
        } catch (IOException e) {
            return "home";
        }
        return "redirect:/account/second-page";
    }
    
    @GetMapping("/second-page")
    public String showStaffEmulment(HttpServletResponse response, 
    Model model) {
        Emulment emulment;
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("company")){
                return "redirect:/account/";    
            }else if(repo.contains("emulment")){
                emulment = mapper.convertValue(repo.findAll().get("emulment"), Emulment.class);
            }else{
                emulment = new Emulment();
            }
        } catch (FileNotFoundException ex) {
            return "redirect:/account/";
        } catch (IOException | NullPointerException ex) {
            emulment = new Emulment();
        }
        model.addAttribute("header", "REGISTRATION OF EMPLOYERS");
        model.addAttribute("links", links.registrationSidebarLinks());
        model.addAttribute("emulment", emulment);
        return "emulment";
    }
    
    @PostMapping("/second-page")
    public String showStaffEmulmentForm(HttpServletResponse response, 
    Model model,  
    @ModelAttribute @Valid Emulment emulment, 
    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("header", header);
            model.addAttribute("links", links.registrationSidebarLinks());
            model.addAttribute("emulment", emulment);
            return "emulment";
        }
        //2. Convert object to JSON string and save into a file directly
        try  {
            map.put("emulment", emulment);
            repo.save(map);
        } catch (IOException e) {
            return "emulment";
        }
        return "redirect:/account/third-page";
    }
    
    @GetMapping("/third-page")
    public String showBusinessClass(HttpServletResponse response, 
    Model model) {
        Sector sect;
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("company")){
                return "redirect:/account/";    
            }else if(!repo.contains("emulment")){
                return "redirect:/account/second-page";
            }else if(repo.contains("sector")){
                sect = mapper.convertValue(repo.findAll().get("sector"), Sector.class);
            }else{
                sect = new Sector();
            }
        } catch (FileNotFoundException ex) {
            return "redirect:/account/";
        } catch (IOException | NullPointerException ex) {
            sect = new Sector();
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links.registrationSidebarLinks());
        model.addAttribute("businessClass", sect);
        return "sector";
    }
    
    @PostMapping("/third-page")
    public String showBusinessClassForm(HttpServletResponse response,
    Model model,
    @ModelAttribute @Valid Sector sect, 
    BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            model.addAttribute("header", header);
            model.addAttribute("links", links.registrationSidebarLinks());
            model.addAttribute("businessClass", sect);
            return "sector";
        }
        //2. Convert object to JSON string and save into a file directly
        try {
            map.put("sector", sect);
            repo.save(map);
        } catch (IOException e) {
            return "sector";
        }
        return "redirect:/account/fourth-page";
    }
    
    @GetMapping("/fourth-page")
    public String showOwnersParticular(HttpServletResponse response, 
    Model model){
        OwnersParticular particular;
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("company")){
                return "redirect:/account/";    
            }else if(!repo.contains("emulment")){
                return "redirect:/account/second-page";
            }else if(!repo.contains("sector")){
                return "redirect:/account/third-page";
            }else if(repo.contains("particular")){
                particular = mapper.convertValue(repo.findAll().get("particular"), OwnersParticular.class);
            }else{
                particular = new OwnersParticular();
            }
        } catch (FileNotFoundException ex) {
            return "redirect:/account/"; 
        } catch (IOException | NullPointerException ex) {
            particular = new OwnersParticular();
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links.registrationSidebarLinks());
        model.addAttribute("particular", particular);
        return "owners-particular";
    }
    
    @PostMapping("/fourth-page")
    public String showOwnersParticularForm(HttpServletResponse response, 
    Model model, 
    @ModelAttribute OwnersParticular particular,
    BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            model.addAttribute("header", header);
            model.addAttribute("links", links.registrationSidebarLinks());
            model.addAttribute("particular", particular);
            return "owners-particular";
        }
        //2. Convert object to JSON string and save into a file directly
        try  {
            map.put("particular", particular);
            repo.save(map);
        } catch (IOException e) {
            return "owners-particular";
        }
        return "redirect:/account/fifth-page";
    }
    
    
    @GetMapping("/fifth-page")
    public String showStaffInfo(HttpServletResponse response,
    Model model) {
        Employee employee;
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("company")){
                return "redirect:/account/";    
            }else if(!repo.contains("emulment")){
                return "redirect:/account/second-page";
            }else if(!repo.contains("sector")){
                return "redirect:/account/third-page";
            }else if(!repo.contains("particular")){
                return "redirect:/account/fourth-page";
            }else if(repo.contains("employee")){
                employee = mapper.convertValue(repo.findAll().get("employee"), Employee.class);
            }else{
                employee = new Employee();
            }
        } catch (FileNotFoundException ex) {
            return "redirect:/account/";
        } catch (IOException | NullPointerException ex) {
            employee = new Employee();
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links.registrationSidebarLinks());
        model.addAttribute("staffInfo", employee);
        return "employee-info";
    }
    
    @PostMapping("/fifth-page")
    public String showStaffInfoForm(HttpServletResponse response,
    Model model,
    @ModelAttribute Employee staffInfo,
    BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            model.addAttribute("header", header);
            model.addAttribute("links", links.registrationSidebarLinks());
            model.addAttribute("staffInfo", staffInfo);
            return "employee-info";
        }
        //2. Convert object to JSON string and save into a file directly
        try {
            map.put("employee", staffInfo);
            repo.save(map);
        } catch (IOException e) {
            return "employee-info";
        }
        return "redirect:/account/preview";
    }
    
    @GetMapping("/preview")
    public String showPreviewForm(HttpServletRequest request,
    Model model,
    HttpServletResponse response){
        try {
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            if(!repo.contains("company")){
                return "redirect:/account/";    
            }else if(!repo.contains("emulment")){
                return "redirect:/account/second-page";
            }else if(!repo.contains("sector")){
                return "redirect:/account/third-page";
            }else if(!repo.contains("particular")){
                return "redirect:/account/fourth-page";
            }
            Company company = mapper.convertValue(repo.findAll().get("company"), Company.class);
            States states = state.findByObjectId(Integer.parseInt(company.getState()));
            company.setState(states.getName());
            model.addAttribute("header", header);
            model.addAttribute("links", links.registrationSidebarLinks());
            model.addAttribute("company", company);
            model.addAttribute("emulment", repo.findByObjectId("emulment"));
            model.addAttribute("sector", repo.findByObjectId("sector"));
            model.addAttribute("particular", repo.findByObjectId("particular"));
            model.addAttribute("employee", repo.findByObjectId("employee"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "preview";
    }
    
    @PostMapping("/save")
    String saveRequest(Model model) {
        Company company;
        try {
            // Set UserId to Request Field USER_ID
            //Users user = usersRepository.findOneByInitialName(principal.getName());
            // 1. JSON to Java object, read it from a file.
            repo.initRepo(collectionType);
            company = mapper.convertValue(repo.findAll().get("company"), Company.class);
            address.insert(company);
            //customerDAO.create(company);
            //this.employeeService.save(company.get("company"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "finish";
    }
}