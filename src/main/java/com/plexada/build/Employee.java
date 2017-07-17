/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.util.ArrayList;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SAP Training
 */
public class Employee{
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String otherName;
    @NotEmpty
    private String position;
    @NotEmpty
    private String staffID;
    //@NotEmpty
    //private MultipartFile[] images;
    
    private List<byte[]> file = new ArrayList();
    @NotEmpty
    private String agreement;
    
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
     * @return the signature
     *
    public MultipartFile[] getImages() {
        return images;
    }

    /**
     * @param images the images to set
     *
    public void setImages(MultipartFile[] images) {
        this.images = images;
    }*/
    
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

    /**
     * @return the file
     */
    public List<byte[]> getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(List<byte[]> file) {
        this.file = file;
    }
}
