/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author SAP Training
 */
@Controller
public class formController {
   @RequestMapping(value = "/first", method = RequestMethod.GET)
   public String first() {
      return "second";
   }
   @RequestMapping(value = "/second", method = RequestMethod.GET)
   public String second() {
      return "third";
   }
   @RequestMapping(value = "/third", method = RequestMethod.GET)
   public String third() {
      return "fourth";
   }
}