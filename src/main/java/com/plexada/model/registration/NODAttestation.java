/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.registration;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author SAP Training
 */
public class NODAttestation {
    @NotEmpty
    private String signature;
    @NotEmpty
    private String stamp;
    @NotEmpty
    private String name;
    @NotEmpty
    private String div_checkbox;

    /**
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * @return the stamp
     */
    public String getStamp() {
        return stamp;
    }

    /**
     * @param stamp the stamp to set
     */
    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the div_checkbox
     */
    public String getDiv_checkbox() {
        return div_checkbox;
    }

    /**
     * @param div_checkbox the div_checkbox to set
     */
    public void setDiv_checkbox(String div_checkbox) {
        this.div_checkbox = div_checkbox;
    }
    
}