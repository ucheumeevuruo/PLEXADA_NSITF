/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author SAP Training
 */
public class OwnersParticular implements Externalizable{
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String position;
    @NotEmpty @Email
    private String email;
    @NotEmpty
    private String modeOfId;
    @NotEmpty
    private String licenseNumber;
    @NotEmpty
    private String licenseNumberDate;
    @NotEmpty
    private String nationalId;
    @NotEmpty
    private String nationalIdDate;
    @NotEmpty
    private String passport;
    @NotEmpty
    private String passportDate;
    @NotEmpty
    private String phoneNumber;

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
     * @return the licenseNumberDate
     */
    public String getLicenseNumberDate() {
        return licenseNumberDate;
    }

    /**
     * @param licenseNumberDate the licenseNumberDate to set
     */
    public void setLicenseNumberDate(String licenseNumberDate) {
        this.licenseNumberDate = licenseNumberDate;
    }

    /**
     * @return the nationalId
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * @param nationalId the nationalId to set
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     * @return the nationalIdDate
     */
    public String getNationalIdDate() {
        return nationalIdDate;
    }

    /**
     * @param nationalIdDate the nationalIdDate to set
     */
    public void setNationalIdDate(String nationalIdDate) {
        this.nationalIdDate = nationalIdDate;
    }

    /**
     * @return the passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport the passport to set
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return the passportDate
     */
    public String getPassportDate() {
        return passportDate;
    }

    /**
     * @param passportDate the passportDate to set
     */
    public void setPassportDate(String passportDate) {
        this.passportDate = passportDate;
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.firstName);
        out.writeObject(this.lastName);
        out.writeObject(this.modeOfId);
        out.writeObject(this.licenseNumber);
        out.writeObject(this.licenseNumberDate);
        out.writeObject(this.nationalId);
        out.writeObject(this.nationalIdDate);
        out.writeObject(this.passport);
        out.writeObject(this.passportDate);
        out.writeObject(this.phoneNumber);
        out.writeObject(this.position);
        out.writeObject(this.email);
       
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.firstName = (String)in.readObject();
        this.lastName = (String)in.readObject();
        this.modeOfId = (String)in.readObject();
        this.licenseNumber = (String)in.readObject();
        this.licenseNumberDate = (String)in.readObject();
        this.nationalId = (String)in.readObject();
        this.nationalIdDate = (String)in.readObject();
        this.passport = (String)in.readObject();
        this.passportDate = (String)in.readObject();
        this.phoneNumber = (String)in.readObject();
        this.position = (String)in.readObject();
        this.email = (String)in.readObject();
        
    }
    
}

