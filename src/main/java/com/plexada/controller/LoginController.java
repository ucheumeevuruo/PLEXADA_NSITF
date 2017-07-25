/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.build.Link;
import com.plexada.build.NavLinks;
import com.plexada.model.registration.LoginModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/ecs")
public class LoginController {
    List<Link> links = NavLinks.ECSLoginSidebarLinks();
    private String path;
    private final String header = "ECS";
    //ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    //LoginService loginService = (LoginService) context.getBean("userDAO");
    
    @GetMapping ("/login")
    public String showLogin(HttpServletRequest request, 
    Model model) {
        model.addAttribute("header", "ECS-Login");
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("vars", new LoginModel());
        path = "ECS-Login";
        return this.path;
    }
    
    @PostMapping ("/login")
    public String postLoginForm (Model model,
        @ModelAttribute LoginModel loginModel) {
        this.path = "ECS-Login";
        if (loginModel != null && loginModel.getUsername() != null & loginModel.getPassword() != null) {
            //LoginModel User = loginService.login(loginModel);
            if(loginModel != null){
                this.path = "redirect:/ecs/home";
            }else{
                model.addAttribute("error", "Connection failed. Please try again later.");
            }
        } else {
            model.addAttribute("error", "Please enter Details");
        }
        
        model.addAttribute("header", "ECS-Login");
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("vars", loginModel);
        return this.path;
    }  
}
