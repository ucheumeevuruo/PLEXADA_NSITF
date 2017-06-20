/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//import com.journaldev.spring.form.validator.Phone;

/**
 *
 * @author SAP Training
 */
//@Entity
public class Company implements Externalizable {

    @Id
    private Long id;
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.company);
        out.writeObject(this.address);
        out.writeObject(this.email);
        out.writeObject(this.houseNo);
        out.writeObject(this.phoneNumber);
        out.writeObject(this.tinNum);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.company = (String)in.readObject();
        this.address = (String)in.readObject();
        this.email = (String)in.readObject();
        this.houseNo = (String)in.readObject();
        this.phoneNumber = (String)in.readObject();
        this.tinNum = (String)in.readObject();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
