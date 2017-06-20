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
        out.writeObject(this.phoneNumber);
        out.writeObject(this.position);
        out.writeObject(this.email);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.firstName = (String)in.readObject();
        this.lastName = (String)in.readObject();
        this.modeOfId = (String)in.readObject();
        this.phoneNumber = (String)in.readObject();
        this.position = (String)in.readObject();
        this.email = (String)in.readObject();
    }
}
