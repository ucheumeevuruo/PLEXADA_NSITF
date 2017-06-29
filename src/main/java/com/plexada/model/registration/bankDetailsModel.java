/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.registration;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author SAP Training
 */
public class bankDetailsModel {
    @NotEmpty
    private String bankName;
    @NotEmpty
    private String accName;
    @NotEmpty
    private String accNumber;
    @NotEmpty
    private String sortCode;
    @NotEmpty
    private String fileToUpload;
    @NotEmpty
    private String fileToUpload1;
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
     * @return the fileToUpload
     */
    public String getFileToUpload() {
        return fileToUpload;
    }

    /**
     * @param fileToUpload the fileToUpload to set
     */
    public void setFileToUpload(String fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    /**
     * @return the fileToUpload1
     */
    public String getFileToUpload1() {
        return fileToUpload1;
    }

    /**
     * @param fileToUpload1 the fileToUpload1 to set
     */
    public void setFileToUpload1(String fileToUpload1) {
        this.fileToUpload1 = fileToUpload1;
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