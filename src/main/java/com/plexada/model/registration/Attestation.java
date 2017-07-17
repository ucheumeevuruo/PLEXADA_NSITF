/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.registration;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SAP Training
 */
public class Attestation {
    @NotEmpty
    private String bankName;
    @NotEmpty
    private String accName;
    @NotEmpty
    private String accNumber;
    @NotEmpty
    private String sortCode;
    @NotEmpty
    private MultipartFile[] images;
    @NotEmpty
    private String tandc;

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return the accName
     */
    public String getAccName() {
        return accName;
    }

    /**
     * @param accName the accName to set
     */
    public void setAccName(String accName) {
        this.accName = accName;
    }

    /**
     * @return the accNumber
     */
    public String getAccNumber() {
        return accNumber;
    }

    /**
     * @param accNumber the accNumber to set
     */
    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    /**
     * @return the sortCode
     */
    public String getSortCode() {
        return sortCode;
    }

    /**
     * @param sortCode the sortCode to set
     */
    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    /**
     * @return the images
     */
    public MultipartFile[] getFileToUpload() {
        return images;  
    }

    /**
     * @param fileToUpload the images to set
     */
    public void setFileToUpload(MultipartFile[] fileToUpload) {
        this.images = fileToUpload; 
    }

    /**
     * @return the tandc
     */
    public String getTandc() {
        return tandc;
    }

    /**
     * @param tandc the tandc to set
     */
    public void setTandc(String tandc) {
        this.tandc = tandc;
    }  
}