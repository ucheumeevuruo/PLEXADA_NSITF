/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SAP Training
 */
public class OwnersParticular{

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
    private String phoneNumber;
    @NotEmpty
    private String ownersFirstName;
    @NotEmpty
    private String ownersOtherName;
    @NotEmpty
    private String ownersPosition;
    @NotEmpty
    private String staffID;
    //@NotEmpty    
    private MultipartFile stamp;
    @NotEmpty
    private String agreement;
    private List<byte[]> file = new ArrayList();

    
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
    public String getModeOfId() {
        return modeOfId;
    }

    /**
     * @param modeOfId the modeOfId to set
     */
    public void setModeOfId(String modeOfId) {
        this.modeOfId = modeOfId;
    }

    /**
     * @return the licenseNumber
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * @param licenseNumber the licenseNumber to set
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * @return the expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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
     * @return the ownersFirstName
     */
    public String getOwnersFirstName() {
        return ownersFirstName;
    }

    /**
     * @param ownersFirstName the ownersFirstName to set
     */
    public void setOwnersFirstName(String ownersFirstName) {
        this.ownersFirstName = ownersFirstName;
    }

    /**
     * @return the ownersOtherName
     */
    public String getOwnersOtherName() {
        return ownersOtherName;
    }

    /**
     * @param ownersOtherName the ownersOtherName to set
     */
    public void setOwnersOtherName(String ownersOtherName) {
        this.ownersOtherName = ownersOtherName;
    }

    /**
     * @return the ownersPosition
     */
    public String getOwnersPosition() {
        return ownersPosition;
    }

    /**
     * @param ownersPosition the ownersPosition to set
     */
    public void setOwnersPosition(String ownersPosition) {
        this.ownersPosition = ownersPosition;
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
     * @return the stamp
     */
    public MultipartFile getStamp() {
        return stamp;
    }

    /**
     * @param stamp the stamp to set
     */
    public void setStamp(MultipartFile stamp) {
        this.stamp = stamp;
    }

    /**
     * @return the agreement
     */
    public String getAgreement() {
        return agreement;
    }

    /**
     * @param agreement the agreement to set
     */
    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }
    
    public List<byte[]> getFile(){
        return this.file;
    }
    
    public void setFile(List<byte[]> file){
        this.file = file;
    }
}

