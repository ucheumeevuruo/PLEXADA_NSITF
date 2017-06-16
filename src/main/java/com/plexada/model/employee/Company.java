/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.employee;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

//import com.journaldev.spring.form.validator.Phone;

/**
 *
 * @author SAP Training
 */
public class Company {
    @NotEmpty
    private String company;
    //@NotNull
    private String incNumber;
   // @NotNull
    private String tinNum;
    @NotEmpty @Email 
    private String email;
    private String phoneNumber;
    //@NotNull
    private String houseNo;
    //@NotNull
    private String address;
    //@NotNull
    private String staffEmulment;
    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @return the incNumber
     */
    public String getIncNumber() {
        return incNumber;
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
     * @param incNumber the incNumber to set
     */
    public void setIncNumber(String incNumber) {
        this.incNumber = incNumber;
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
