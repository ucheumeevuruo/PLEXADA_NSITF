/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.build.Emulment;
import com.plexada.build.Link;
import com.plexada.build.NavLinks;
import com.plexada.model.States;
import com.plexada.services.CompanyService;
import com.plexada.services.StateService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;
import org.unbescape.html.HtmlEscape;

/**
 *
 * @author SAP Training
 */
@Controller
@RequestMapping("/ecs")
public class ECSController {
    List<Link> links = NavLinks.ECSSidebarLinks();
    private String path;
    private final String header = "ECS";
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

    //Cookie customerDAO = (Cookie) context.getBean("customerDAO");stateDAO
    CompanyService companyService = (CompanyService)context.getBean("companyDOA");
    StateService state = (StateService) context.getBean("stateDAO");
    
    
    @GetMapping("/dashboard")
    public String home(Model model){
        
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        path = "ECS-Dashboard";
        return this.path;
    }
    
    @GetMapping("/dashboard/{id}")
    public String homePath(Model model,
    @PathVariable("id") String id){
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        //List<Map<String, Object>> list = companyService.findById(id);
        
        List<Map<String, Object>> list = companyService.findById(id);
        Map<String, Object> map = list.get(0);
        States states = state.findByObjectId(Integer.parseInt(String.valueOf(map.get("state"))));
        map.put("state", states.getName());
        model.addAttribute("vars", map);
        path = "ECS-Dashboard";
        return this.path;
    }
    
    @GetMapping("/notification-type")
    public String showNotification(Model model){
        this.path = "ECS-Notification";
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        return this.path;
    }
    
    @PostMapping("/notification-type/{path}")
    public String postNotificationForm(@PathVariable String path, Model model){
        if(path.equalsIgnoreCase("accident")){
            this.path = "redirect:/notification/" + path;
        }else if(path.equalsIgnoreCase("disease")){
            this.path = "redirect:/notification/occupational-disease";
        }else{
            this.path = "ECS-Notification";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        return this.path;
    }
    
    @GetMapping("/subscription")
    public String showSubscription(Model model){
        this.path = "ECS-Subscription";
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        //model.addAttribute("subscription", links.ECSSidebarLinks());
        return this.path;
    }
    
    @PostMapping("/subscription")
    public String postSubscriptionForm(Model model,  
    @ModelAttribute @Valid Emulment emulment, 
    BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            //Redirect to next page
            //this.path = "redirect:/account/third-page";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        //model.addAttribute("subscription", emulment);
        this.path = "ECS-Subscription";
        return this.path;
    }
    
    @GetMapping("/change-password")
    public String showChangePassword(Model model){
        this.path = "ECS-Change-Password";
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        return this.path;
    }
    
    @PostMapping("/change-password")
    public String postChangePasswordForm(Model model,  
    @ModelAttribute @Valid Emulment emulment, 
    BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            //Redirect to next page
            //this.path = "redirect:/account/third-page";
        }
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        //model.addAttribute("subscription", emulment);
        this.path = "ECS-Change-Password";
        return this.path;
    }
    
    @GetMapping("/search")
    public String showSearch(Model model){
        this.path = "ECS-Search";
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        return this.path;
    }
    
    @PostMapping("/search")
    public String postSearchForm(Model model,  
    @RequestParam("q") String q){
        List<Link> list = new ArrayList();
        Link link = new Link();
        List<Map<String, Object>> searchResult = companyService.findByObjectId(q);
        for(Map<String, Object> result : searchResult){
            link.setHref("/ecs/dashboard/" + result.get("ID"));
            link.setValue((String)result.get("rc_number"));
            list.add(link);
        }
            //Redirect to next page
            //this.path = "redirect:/account/third-page";
        model.addAttribute("header", header);
        model.addAttribute("links", links);
        model.addAttribute("results", list);
        this.path = "ECS-Search";
        return this.path;
    }
}
