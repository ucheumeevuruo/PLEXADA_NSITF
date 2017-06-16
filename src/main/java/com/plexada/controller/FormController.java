/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.model.employee.Company;
import com.plexada.model.employee.Employee;
import com.plexada.model.employee.Emulment;
import com.plexada.model.employee.Sector;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAP Training 
 */
@Controller
@RequestMapping(path = "/account")
public class FormController {
    @GetMapping("")
    public String index(HttpServletResponse response, 
    Model model,
    Company employee) {
        model.addAttribute("employee", new Company());
        return "home";
    }
    
    @PostMapping("")
    public String indexForm(HttpServletResponse response, 
    Model model, 
    @Valid @ModelAttribute Company company, 
    BindingResult bindingResult){
        if(bindingResult.hasErrors())
        {
            model.addAttribute("employee", company);
            return "home";
        }
        response.addCookie(new Cookie("company", company.getCompany()));
        response.addCookie(new Cookie("email", company.getEmail()));
        response.addCookie(new Cookie("house-no", company.getHouseNo()));
        response.addCookie(new Cookie("inc-number", company.getIncNumber()));
        response.addCookie(new Cookie("address", company.getAddress()));
        response.addCookie(new Cookie("tin-num", company.getTinNum()));
        response.addCookie(new Cookie("mobile", company.getPhoneNumber()));
        return "redirect:/account/second-page";
    }
    
    @GetMapping("/second-page")
    public String showStaffEmulment(HttpServletResponse response, Model model) {
        model.addAttribute("staffEmulment", new Emulment());
        return "emulment";
    }
    
    @PostMapping("/second-page")
    public String showStaffEmulmentForm(HttpServletResponse response, 
    Model model,  
    @Valid @ModelAttribute Emulment staffEmulment, 
    BindingResult bindingResult){
        if(bindingResult.hasErrors())
        {
            model.addAttribute("emulment", staffEmulment);
            return "emulment";
        }
        response.addCookie(new Cookie("staffEmulment", String.valueOf(staffEmulment.getStaffEmulment())));
        return "redirect:/account/third-page";
    }
    
    @GetMapping("/third-page")
    public String showBusinessClass(HttpServletResponse response, Model model) {
        model.addAttribute("businessClass", new Sector());
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
        response.addCookie(new Cookie("type", sect.getType()));
        response.addCookie(new Cookie("sector", sect.getSector()));
        response.addCookie(new Cookie("other-sector", sect.getOthersSector()));
        return "redirect:/account/fourth-page";
    }
    
    @GetMapping("/fourth-page")
    public String showOwnersParticular(HttpServletResponse response, Model model)
    {
        model.addAttribute("staffInfo", new Employee());
        return "owners-particular";
    }
    
    @PostMapping("/fourth-page")
    public String showOwnersParticularForm(HttpServletResponse response, 
    Model model, 
    @ModelAttribute Company employee) {
        model.addAttribute("businessClass", employee);
        return "owners-particular";
    }
    
    
    @GetMapping("/fifth-page")
    public String showStaffInfo(HttpServletResponse response, Model model) {
        model.addAttribute("staffInfo", new Employee());
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
        response.addCookie(new Cookie("first-name", staffInfo.getFirstName()));
        response.addCookie(new Cookie("other-name", staffInfo.getOtherName()));
        response.addCookie(new Cookie("position", staffInfo.getPosition()));
        response.addCookie(new Cookie("staff-id", String.valueOf(staffInfo.getStaffID())));
        return "redirect:/account/preview";
    }
    
    @GetMapping("/preview")
    public String showPreviewForm(HttpServletRequest request,
    Model model,
    HttpServletResponse response) {
         //At this point fooCookie is truncated 
        for (Cookie cookie : request.getCookies()) {
            model.addAttribute(cookie.getName(), cookie.getValue());
        }
        return "preview";
    }
}