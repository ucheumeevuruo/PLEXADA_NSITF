/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.lib.validator;

/**
 *
 * @author SAP Training
 */
public class FormValidation {
    // Check if the input supplied meets the requirement of an email address
    public boolean isValidEmail()
    {
        return false;
    }
    
    // Validate phone numbers by country
    public boolean isValidPhoneNumber(String country)
    {
        /*
            get the phone validation class
            GlobalMobile mobile = new GlobalMobile(CountryMobileFormat country);
            return mobile.isValidate();
        */
        return false;
    }
}
