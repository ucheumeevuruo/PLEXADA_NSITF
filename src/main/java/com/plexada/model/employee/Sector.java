/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.employee;

/**
 *
 * @author SAP Training
 */
public class Sector {
    private String type;
    private String sector;
    private String othersSector;
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @return the othersSector
     */
    public String getOthersSector() {
        return othersSector;
    }

    /**
     * @param othersSector the othersSector to set
     */
    public void setOthersSector(String othersSector) {
        this.othersSector = othersSector;
    }
}
