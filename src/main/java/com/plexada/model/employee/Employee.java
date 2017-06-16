/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.employee;

import java.beans.PropertyChangeSupport;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author SAP Training
 */
public class Employee {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String otherName;
    @NotEmpty
    private String position;
    @NotEmpty
    private Integer staffID;
    
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
     * @return the otherName
     */
    public String getOtherName() {
        return otherName;
    }

    /**
     * @param otherName the otherName to set
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the StaffID
     */
    public Integer getStaffID() {
        return staffID;
    }

    /**
     * @param StaffID the StaffID to set
     */
    public void setStaffID(Integer StaffID) {
        this.staffID = StaffID;
    }
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    public static final String PROP_STAFFID = "staffID";
}
