/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.plexada.model.employee.Request;
import com.plexada.model.employee.Company;
import com.plexada.model.employee.Employee;
import com.plexada.model.employee.Emulment;
import com.plexada.model.employee.OwnersParticular;
import com.plexada.model.employee.Sector;
import com.plexada.repositories.ProductRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Principal;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.catalina.servlet4preview.ServletContext;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonGenerationException;

/**
 *
 * @author SAP Training 
 */
@Controller
@RequestMapping(path = "/account")
public class FormController {
    //@Autowired
    //private ProductRepository requestRepository;
    
    private final Gson gson = new Gson();
    private FileReader fileReader = null;
    Map<String, Object> mapper = new HashMap();
    Type collectionType = new TypeToken<Map<String, Object>>(){}.getType();
    private static final String FILE = "C:\\temp\\test.json";
    
    @GetMapping("")
    public String index(HttpServletResponse response, 
    Model model) {
        Company company;
        try {
            // 1. JSON to Java object, read it from a file.
            fileReader = new FileReader(FILE);
            Map<String, Company> map = gson.fromJson(fileReader, 
                new TypeToken<Map<String, Company>>(){}.getType()
            );
            company = map.get("company");
            if(!(company instanceof Company)){
                company = new Company();
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
            company = new Company();
        } catch (IOException | NullPointerException ex) {
            company = new Company();
        }
        model.addAttribute("employee", company);
        return "home";
    }
    
    @PostMapping("")
    public String indexForm(HttpServletResponse response,
    Model model, 
    @Valid Company company, 
    BindingResult bindingResult) throws IOException, FileNotFoundException{
        if(bindingResult.hasErrors()){
            model.addAttribute("employee", company);
            return "home";
        }
        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter(FILE)) {
            Map<String, Company> map = new HashMap();
            map.put("company", company);
            mapper.putAll(map);
            gson.toJson(mapper, writer);
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
            fileReader = new FileReader(FILE);
            Map<String, Company> mapcheck = gson.fromJson(fileReader, 
                new TypeToken<Map<String, Company>>(){}.getType()
            );
            Company company = mapcheck.get("company");
            if(!(company instanceof Company)){
                return "redirect:/account/";
            }
            Map<String, Emulment> map = gson.fromJson(fileReader, 
                new TypeToken<Map<String, Emulment>>(){}.getType()
            );
            emulment = map.get("emulment");
            if(!(emulment instanceof Emulment)){
                emulment = new Emulment();
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
            return "redirect:/account/";
        } catch (IOException | NullPointerException ex) {
            emulment = new Emulment();
        }
        model.addAttribute("emulment", emulment);
        return "emulment";
    }
    
    @PostMapping("/second-page")
    public String showStaffEmulmentForm(HttpServletResponse response, 
    Model model,  
    @Valid @ModelAttribute Emulment emulment, 
    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("emulment", emulment);
            return "emulment";
        }
        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter(FILE)) {
            mapper.put("emulment", emulment);
            gson.toJson(mapper, writer);
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
            fileReader = new FileReader(FILE);
            Map<String, Emulment> mapcheck = gson.fromJson(fileReader, 
                new TypeToken<Map<String, Emulment>>(){}.getType()
            );
            Emulment emulment = mapcheck.get("company");
            if(!(emulment instanceof Emulment)){
                return "redirect:/account/second-page";
            }
            Map<String, Sector> map = gson.fromJson(fileReader, 
                new TypeToken<Map<String, Sector>>(){}.getType()
            );
            sect = map.get("emulment");
            if(!(sect instanceof Sector)){
                sect = new Sector();
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
            sect = new Sector();
        } catch (IOException | NullPointerException ex) {
            sect = new Sector();
        }
        model.addAttribute("businessClass", sect);
        return "sector";
    }
    
    @PostMapping("/third-page")
    public String showBusinessClassForm(HttpServletResponse response,
    Model model,
    @Valid @ModelAttribute Sector sect, 
    BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            model.addAttribute("businessClass", sect);
            return "sector";
        }
        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter(FILE)) {
            mapper.put("sector", sect);
            gson.toJson(mapper, writer);
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
            fileReader = new FileReader(FILE);
            Map<String, Sector> mapcheck = gson.fromJson(fileReader, 
                new TypeToken<Map<String, Sector>>(){}.getType()
            );
            Sector sect = mapcheck.get("company");
            if(!(sect instanceof Sector)){
                return "redirect:/account/third-page";
            }
            Map<String, OwnersParticular> map = gson.fromJson(fileReader, 
                new TypeToken<Map<String, OwnersParticular>>(){}.getType()
            );
            particular = map.get("emulment");
            if(!(particular instanceof OwnersParticular)){
                particular = new OwnersParticular();
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
            particular = new OwnersParticular();
        } catch (IOException | NullPointerException ex) {
            particular = new OwnersParticular();
        }
        model.addAttribute("particular", particular);
        return "owners-particular";
    }
    
    @PostMapping("/fourth-page")
    public String showOwnersParticularForm(HttpServletResponse response, 
    Model model, 
    @ModelAttribute OwnersParticular particular,
    BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            model.addAttribute("particular", particular);
            return "owners-particular";
        }
        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter(FILE)) {
            mapper.put("particular", particular);
            gson.toJson(mapper, writer);
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
            fileReader = new FileReader(FILE);
            Map<String, OwnersParticular> mapcheck = gson.fromJson(fileReader, 
                new TypeToken<Map<String, OwnersParticular>>(){}.getType()
            );
            OwnersParticular particular = mapcheck.get("company");
            if(!(particular instanceof OwnersParticular)){
                return "redirect:/account/third-page";
            }
            Map<String, Employee> map = gson.fromJson(fileReader, 
                new TypeToken<Map<String, Employee>>(){}.getType()
            );
            employee = map.get("emulment");
            if(!(employee instanceof Employee)){
                employee = new Employee();
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
            employee = new Employee();
        } catch (IOException | NullPointerException ex) {
            employee = new Employee();
        }
        model.addAttribute("staffInfo", employee);
        return "employee-info";
    }
    
    @PostMapping("/fifth-page")
    public String showStaffInfoForm(HttpServletResponse response,
    Model model,
    @ModelAttribute Employee staffInfo,
    BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
           model.addAttribute("staffInfo", staffInfo);
           return "employee-info";
        }
        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter(FILE)) {
            mapper.put("employee", staffInfo);
            gson.toJson(mapper, writer);
        } catch (IOException e) {
            return "employee-info";
        }
        return "redirect:/account/preview";
    }
    
    @GetMapping("/preview")
    public String showPreviewForm(HttpServletRequest request,
    Model model,
    ServletContext servletContext,
    HttpServletResponse response) {
        for (Cookie cookie : request.getCookies()) {
            model.addAttribute(cookie.getName(), cookie.getValue());
        }
        return "preview";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String saveRequest(Principal principal, 
    @ModelAttribute Employee request, 
    Model model) {
        // Set UserId to Request Field USER_ID
        //Users user = usersRepository.findOneByInitialName(principal.getName());
        Request requestObj = new Request();
        
        // Set Additional Request Fields
        /*
        requestObj.company().setCompany(company);
        requestObj.company().setIncNumber(incNumber);
        requestObj.company().setTinNum(tinNum);
        requestObj.company().setEmail(email);
        requestObj.company().setPhoneNumber(phoneNumber);
        requestObj.company().setHouseNo(houseNo);
        requestObj.company().setAddress(address);
        requestObj.emulment().setStaffEmulment(Integer.MAX_VALUE);
        requestObj.sector().setType(type);
        requestObj.sector().setSector(sector);
        requestObj.sector().setOtherSector(otherSector);
        requestObj.particular().setFirstName(firstName);
        requestObj.particular().setLastName(lastName);
        requestObj.particular().setPosition(position);
        requestObj.particular().setModeOfId(modeOfId);*/
        // Save Request Object
        //requestRepository.save(requestObj);
        
        Object obj = null;
        try {
            FileInputStream fileIn = null;
            fileIn = new FileInputStream("C:\\Temp\\page5.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            obj = new Employee();
        } catch (IOException | ClassNotFoundException ex) {
            obj = new Employee();
        }
        return "requests";
    }
}