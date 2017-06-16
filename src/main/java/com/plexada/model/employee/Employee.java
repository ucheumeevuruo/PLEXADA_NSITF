/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.employee;

import javax.validation.constraints.NotNull;

/**
 *
 * @author SAP Training
 */
public class Employee {
    @NotNull
    private String firstName;
    @NotNull
    private String otherName;
    @NotNull
    private String position;
    @NotNull
    private String staffID;
    @NotNull
    private String company;
    @NotNull
    private String impNumber;
    @NotNull
    private String tinNum;
    @NotNull
    private String email;
    private String phoneNumber;
    @NotNull
    private String houseNo;
    @NotNull
    private String address;
    @NotNull
    private String staffEmulment;
    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @return the impNumber
     */
    public String getImpNumber() {
        return impNumber;
    }

    /**
     * @return the tinNum
     */
    public String getTinNum() {
        return tinNum;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return the houseNo
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @param impNumber the impNumber to set
     */
    public void setImpNumber(String impNumber) {
        this.impNumber = impNumber;
    }

    /**
     * @param tinNum the tinNum to set
     */
    public void setTinNum(String tinNum) {
        this.tinNum = tinNum;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @param houseNo the houseNo to set
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
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
    public String getStaffID() {
        return staffID;
    }

    /**
     * @param StaffID the StaffID to set
     */
    public void setStaffID(String StaffID) {
        this.staffID = StaffID;
    }
    
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
