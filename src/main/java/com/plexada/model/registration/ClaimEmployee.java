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
public class ClaimEmployee {
    @NotEmpty
    private String firstName;
    private String middleName;
    @NotEmpty
    private String lastName;
    private String employeeId;
    @NotEmpty
    private String staffID;
    @NotEmpty
    private String earnings;
    @NotEmpty
    private Integer years;
    @NotEmpty
    private String months;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the staffID
     */
    public String getStaffID() {
        return staffID;
    }

    /**
     * @param staffID the staffID to set
     */
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    /**
     * @return the earnings
     */
    public String getEarnings() {
        return earnings;
    }

    /**
     * @param earnings the earnings to set
     */
    public void setEarnings(String earnings) {
        this.earnings = earnings;
    }

    /**
     * @return the years
     */
    public Integer getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(Integer years) {
        this.years = years;
    }

    /**
     * @return the months
     */
    public String getMonths() {
        return months;
    }

    /**
     * @param months the months to set
     */
    public void setMonths(String months) {
        this.months = months;
    }
   
	
}