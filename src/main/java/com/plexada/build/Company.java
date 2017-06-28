/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import com.plexada.model.impl.Address;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//import com.journaldev.spring.form.validator.Phone;

/**
 *
 * @author SAP Training
 */
//@Entity
//@Table(name="USER")  
public class Company implements Address{

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String company;
    @NotEmpty
    private String incNumber;
   // @NotNull
    private String tinNum;
    @NotEmpty
    private String incYear;
    @NotEmpty @Email 
    private String email;
    private String phoneNumber;
    @NotEmpty
    private String state;
    @NotEmpty
    private String province;
    @NotEmpty
    private String houseNo;
    @NotEmpty
    private String streetName;
    private String city;
    private String country;
    
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
    @Override
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * @return the streetName
     */
    @Override
    public String getStreetName() {
        return streetName;
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
    @Override
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * @param streetName the streetName to set
     */
    @Override
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the state
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    @Override
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the province
     */
    @Override
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    @Override
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the incYear
     */
    public String getIncYear() {
        return incYear;
    }

    /**
     * @param incYear the incYear to set
     */
    public void setIncYear(String incYear) {
        this.incYear = incYear;
    }
    
    /**
     * @return the city
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    @Override
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    @Override
    public void setCountry(String country) {
        this.country = country;
    }
}