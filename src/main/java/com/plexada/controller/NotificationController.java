/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author SAP Training
 */
@Controller
public class NotificationController {
    @GetMapping()
    public String Details(){
        return "";
    }
    
    @GetMapping()
    public String Accident(){
        return "";
    }
    
    @GetMapping()
    public String Attestation(){
        return "";
    }
}
