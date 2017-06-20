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
import javax.validation.constraints.NotNull;

/**
 *
 * @author SAP Training
 */
public class Sector implements Externalizable {
    @NotNull
    private String type;
    @NotNull
    private String sector;
    private String otherSector;
    
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.type);
        out.writeObject(this.sector);
        out.writeObject(this.otherSector);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.type = (String)in.readObject();
        this.sector = (String)in.readObject();
        this.otherSector = (String)in.readObject();
    }
}
