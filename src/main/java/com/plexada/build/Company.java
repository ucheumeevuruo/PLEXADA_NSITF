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
    
    private String id;
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
    private String region;
    @NotEmpty
    private String branch;
    @NotEmpty
    private String houseNo;
    @NotEmpty
    private String streetName;
    private String city;
    private String country;
    @NotEmpty
    private String staffEmulment;
    @NotEmpty
    private String type;
    @NotEmpty
    private String sector;
    private String otherSector;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String position;
    @NotEmpty @Email
    private String email2;
    @NotEmpty
    private String modeOfId;
    //@NotEmpty
    private String licenseNumber;
    //@NotEmpty
    private String expiryDate;
    @NotEmpty
    private String phoneNumber2;
    
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the incNumber
     */
    public String getIncNumber() {
        return incNumber;
    }

    /**
     * @param incNumber the incNumber to set
     */
    public void setIncNumber(String incNumber) {
        this.incNumber = incNumber;
    }

    /**
     * @return the tinNum
     */
    public String getTinNum() {
        return tinNum;
    }

    /**
     * @param tinNum the tinNum to set
     */
    public void setTinNum(String tinNum) {
        this.tinNum = tinNum;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the houseNo
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * @param houseNo the houseNo to set
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
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
     * @return the otherSector
     */
    public String getOtherSector() {
        return otherSector;
    }

    /**
     * @param otherSector the otherSector to set
     */
    public void setOtherSector(String otherSector) {
        this.otherSector = otherSector;
    }
    
    /**
     * @return the firstName
     */
    public String getfirstName() {
        return firstName;
    }
    
    /**
     * @param firstName the firstName to set
     */
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * @return the lastName
     */
    public String getlastName() {
        return lastName;
    }
    
    /**
     * @param lastName the lastName to set
     */
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * @return the position
     */
    public String getposition() {
        return position;
    }
    
    /**
     * @param position the position to set
     */
    public void setposition(String position) {
        this.position = position;
    }
    
     /**
     * @return the email2
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * @param email2 the email2 to set
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    
      /**
     * @return the modeOfId
     */
    public String getmodeOfId() {
        return modeOfId;
    }

    /**
     * @param modeOfId the modeOfId to set
     */
    public void setmodeOfId(String modeOfId) {
        this.modeOfId = modeOfId;
    }
    
     /**
     * @return the licenseNumber
     */
    public String getlicenseNumber() {
        return licenseNumber;
    }

    /**
     * @param licenseNumber the licenseNumber to set
     */
    public void setlicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    } 
    
    /**
     * @return the expiryDate
     */
    public String getexpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setexpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    } 
    
    /**
     * @return the phoneNumber2
     */
    public String getphoneNumber2() {
        return phoneNumber2;
    }

    /**
     * @param phoneNumber2 the phoneNumber2 to set
     */
    public void setphoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }
    
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
  
    
    
}
