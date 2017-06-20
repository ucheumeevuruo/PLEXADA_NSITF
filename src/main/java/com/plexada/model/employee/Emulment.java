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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author SAP Training
 */
public class Emulment implements Externalizable {
    //@NotEmpty
    private Integer staffEmulment;

    /**
     * @return the staffEmulment
     */
    public Integer getStaffEmulment() {
        return staffEmulment;
    }

    /**
     * @param staffEmulment the staffEmulment to set
     */
    public void setStaffEmulment(Integer staffEmulment) {
        this.staffEmulment = staffEmulment;
    }
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.staffEmulment);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.staffEmulment = (Integer)in.readObject();
    }
}
