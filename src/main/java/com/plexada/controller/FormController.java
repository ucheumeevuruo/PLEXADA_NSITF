/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.model.employee.Employee;
import com.plexada.model.employee.StaffEmulment;
import com.plexada.model.employee.StaffInfo;
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
    public String index(HttpServletResponse response, Model model) {
        model.addAttribute("employee", new Employee());
        return "home";
    }
    
    @PostMapping("")
    public String indexForm(HttpServletResponse response, Model model, @ModelAttribute @Valid Employee employee, BindingResult bindingResult){
        
        model.addAttribute("employee", employee);
        if(bindingResult.hasErrors())
        {
            return "home";
        }
        response.addCookie(new Cookie("company", employee.getCompany()));
        response.addCookie(new Cookie("email", employee.getEmail()));
        response.addCookie(new Cookie("houseNo", employee.getHouseNo()));
        response.addCookie(new Cookie("impNumber", employee.getImpNumber()));
        response.addCookie(new Cookie("address", employee.getAddress()));
        response.addCookie(new Cookie("tinNum", employee.getTinNum()));
        response.addCookie(new Cookie("mobile", employee.getPhoneNumber()));
        return "redirect:/account/second-page";
    }
    
    @GetMapping("/second-page")
    public String showStaffEmulment(HttpServletResponse response, Model model) {
        model.addAttribute("staffEmulment", new Employee());
        return "staffEmulment";
    }
    
    @PostMapping("/second-page")
    public String showStaffEmulmentForm(HttpServletResponse response, Model model, @ModelAttribute Employee staffEmulment){
        response.addCookie(new Cookie("staffEmulment", staffEmulment.getStaffEmulment()));
        model.addAttribute("staffEmulment", staffEmulment);
        if(response.containsHeader(""))
        {
            return "redirect:/account/third-page";
        }
        return "staffEmulment";
    }
    
    @GetMapping("/third-page")
    public String showBusinessClass(HttpServletResponse response, Model model) {
        model.addAttribute("businessClass", new Employee());
        return "businessClass";
    }
    
    @PostMapping("/third-page")
    public String showBusinessClassForm(HttpServletResponse response, Model model, @ModelAttribute Employee employee) {
        model.addAttribute("businessClass", employee);
        return "businessClass";
    }
    
    @PostMapping("/fourth-page")
    public String showOwnersParticularForm(HttpServletResponse response, Model model, @ModelAttribute Employee employee) {
        model.addAttribute("businessClass", employee);
        return "businessClass";
    }
    
    
    @GetMapping("/fifth-page")
    public String showStaffInfo(HttpServletResponse response, Model model) {
        model.addAttribute("staffInfo", new Employee());
        return "staffInfo";
    }
    
    @PostMapping("/fifth-page")
    public String showStaffInfoForm(HttpServletResponse response, Model model, @ModelAttribute Employee staffInfo) {
        response.addCookie(new Cookie("firstName", staffInfo.getFirstName()));
        response.addCookie(new Cookie("otherName", staffInfo.getOtherName()));
        response.addCookie(new Cookie("position", staffInfo.getPosition()));
        response.addCookie(new Cookie("staffId", staffInfo.getStaffID()));
        model.addAttribute("staffInfo", staffInfo);
        return "staffInfo";
    }
    
    @PostMapping("/preview")
    public ModelAndView showPreviewForm(HttpServletRequest request) {
        return new ModelAndView("preview", "request", request);
    }
}
