/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import com.plexada.domain.Company;
import com.plexada.build.OwnersParticular;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.plexada.services.BranchService;
import com.plexada.services.CompanyService;
import com.plexada.services.ProductService;
import com.plexada.services.ProvinceService;
import com.plexada.services.RegionService;
import com.plexada.services.StateService;
import com.siebel.eai.SiebelBusinessServiceException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;


/**
 *
 * @author SAP Training 
 */
@Controller
//@ComponentScan(basePackages = "com.plexada")
@RequestMapping(path = "/account")
public class FormController {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    StateService state = (StateService)context.getBean("stateDAO");
    ProvinceService local = (ProvinceService)context.getBean("localDAO");
    RegionService region = (RegionService)context.getBean ("regionDAO");
    BranchService branch = (BranchService)context.getBean ("branchDAO");
    
    private ProductService productService;
    
    private final CompanyService companyService = new CompanyService();
    
    private String path;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("")
    public String index(HttpServletRequest request, 
    Model model) {
        Company company = new Company(); 
        model.addAttribute("states", state.findAll());
        model.addAttribute("locals", local.findByObjectId(0));
        model.addAttribute("regions", local.findByObjectId(0));
        model.addAttribute("branch", local.findByObjectId(0));
        model.addAttribute("employee", company);
        return "registration";
    }
    
    @PostMapping("")
    public String indexForm(HttpServletRequest request,
    Model model, 
    @ModelAttribute Company company, 
    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //model.addAttribute("header", header);
            //model.addAttribute("links", links.registrationSidebarLinks());
            model.addAttribute("states", state.findAll());
            model.addAttribute("locals", local.findByObjectId(0));
            model.addAttribute("regions", local.findByObjectId(0));
            model.addAttribute("branch", local.findByObjectId(0));
            model.addAttribute("employee", company);
            return "registration";
        }
        this.productService.saveProduct(company);
        return "redirect:/account/preview";
    }
    
    @GetMapping("/preview")
    public String showPreviewForm(HttpServletRequest request,
    Model model,
    HttpServletResponse response){

        //model.addAttribute("header", header);
        //model.addAttribute("links", links.registrationSidebarLinks());
        model.addAttribute("company", this.productService.getProductById(0));
        return "preview";
    }
    
    @PostMapping("/save")
    String save(Model model,
    HttpServletRequest request) {
        Map<String, Object> progress = new HashMap();
        Company company = null;
        try {
            companyService.insert(company);
            progress.put("response", "success");
            progress.put("message", "Registration successful!");
        } catch (SiebelBusinessServiceException ex) {
            progress.put("response", "error");
            progress.put("message", ex.getMessage());
        }
        //model.addAttribute("header", header);
        ///model.addAttribute("links", links.registrationSidebarLinks());
        model.addAttribute("progress", progress);
        return "finish";
    }
    
    @PostMapping("/update")
    public Boolean update(HttpServletRequest request,
    Model model,
    HttpServletResponse response,
    @ModelAttribute Company company){
        //return companyService.update(company, particulars);
        return false;
    }  
   
    @GetMapping("/images/{images_id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("images_id") String imageId,
    HttpServletRequest request){
        byte[] imageContent = null;
        final HttpHeaders headers = new HttpHeaders();
        OwnersParticular particular;
        try {
            //repo = new JsonDBRepository(cookie);
            //repo.initRepo(collectionType);
            //particular = mapper.convertValue(repo.findAll().get("employee"), OwnersParticular.class);
            headers.setContentType(MediaType.IMAGE_GIF);
        } catch (Exception ex) {System.out.println(ex.getMessage());}
        System.out.println(Arrays.toString(imageContent));
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }
}
