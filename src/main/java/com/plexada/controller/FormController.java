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
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String indexForm(HttpServletResponse response, Model model, @ModelAttribute Employee employee){
        response.addCookie(new Cookie("company", employee.getCompany()));
        response.addCookie(new Cookie("email", employee.getEmail()));
        response.addCookie(new Cookie("houseNo", employee.getHouseNo()));
        response.addCookie(new Cookie("impNumber", employee.getImpNumber()));
        response.addCookie(new Cookie("address", employee.getAddress()));
        response.addCookie(new Cookie("tinNum", employee.getTinNum()));
        response.addCookie(new Cookie("mobile", employee.getPhoneNumber()));
        model.addAttribute("employee", employee);
        return "home";
    }
    
    @PostMapping("/second-page")
    public String showStaffEmulmentForm(HttpServletResponse response, Model model, @ModelAttribute StaffEmulment staffEmulment){
        response.addCookie(new Cookie("staffEmulment", staffEmulment.getStaffEmulment()));
        model.addAttribute("staffEmulment", staffEmulment);
        return "staffEmulment";
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
    
    @PostMapping("/fifth-page")
    public String showStaffInfoForm(HttpServletResponse response, Model model, @ModelAttribute StaffInfo staffInfo) {
        response.addCookie(new Cookie("firstName", staffInfo.getFirstName()));
        response.addCookie(new Cookie("otherName", staffInfo.getOtherName()));
        response.addCookie(new Cookie("position", staffInfo.getPosition()));
        response.addCookie(new Cookie("staffId", staffInfo.getStaffID()));
        model.addAttribute("staffInfo", staffInfo);
        return "staffInfo";
    }
    
    @PostMapping("/preview")
    public String showPreviewForm(HttpServletRequest request, Model model) {
        model.addAttribute("preview", request);
        return "preview";
    }
}
