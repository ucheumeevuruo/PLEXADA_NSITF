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
public class healthModel {
    @NotEmpty
    private String div_radio;
    @NotEmpty
    private String dateOfInjury;
    @NotEmpty
    private String dateOfTreat;
    @NotEmpty
    private String hospital;
    @NotEmpty
    private String houseNumber;
    @NotEmpty
    private String streetNumber;
    @NotEmpty
    private String state;
    @NotEmpty
    private String province;
    @NotEmpty
    private String medicFirstName;
    @NotEmpty
    private String medicLastName;
    @NotEmpty
    private String practiceNumber;

    /**
     * @return the div_radio
     */
    public String getDiv_radio() {
        return div_radio;
    }

    /**
     * @param div_radio the div_radio to set
     */
    public void setDiv_radio(String div_radio) {
        this.div_radio = div_radio;
    }

    /**
     * @return the dateOfInjury
     */
    public String getDateOfInjury() {
        return dateOfInjury;
    }

    /**
     * @param dateOfInjury the dateOfInjury to set
     */
    public void setDateOfInjury(String dateOfInjury) {
        this.dateOfInjury = dateOfInjury;
    }

    /**
     * @return the dateOfTreat
     */
    public String getDateOfTreat() {
        return dateOfTreat;
    }

    /**
     * @param dateOfTreat the dateOfTreat to set
     */
    public void setDateOfTreat(String dateOfTreat) {
        this.dateOfTreat = dateOfTreat;
    }

    /**
     * @return the hospital
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    /**
     * @return the houseNumber
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the streetNumber
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * @param streetNumber the streetNumber to set
     */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the medicFirstName
     */
    public String getMedicFirstName() {
        return medicFirstName;
    }

    /**
     * @param medicFirstName the medicFirstName to set
     */
    public void setMedicFirstName(String medicFirstName) {
        this.medicFirstName = medicFirstName;
    }

    /**
     * @return the medicLastName
     */
    public String getMedicLastName() {
        return medicLastName;
    }

    /**
     * @param medicLastName the medicLastName to set
     */
    public void setMedicLastName(String medicLastName) {
        this.medicLastName = medicLastName;
    }

    /**
     * @return the practiceNumber
     */
    public String getPracticeNumber() {
        return practiceNumber;
    }

    /**
     * @param practiceNumber the practiceNumber to set
     */
    public void setPracticeNumber(String practiceNumber) {
        this.practiceNumber = practiceNumber;
    }
      
}