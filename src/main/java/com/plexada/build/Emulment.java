/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author SAP Training
 */
public class Emulment {
    @NotEmpty
    private String staffEmulment;

    /**
     * @return the staffEmulment
     */
    public String getStaffEmulment() {
        return staffEmulment;
    }

    /**
     * @param staffEmulment the staffEmulment to set
     */
    public void setStaffEmulment(String staffEmulment) {
        this.staffEmulment = staffEmulment;
    }
}
