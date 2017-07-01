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
public class Upload {
    @NotEmpty
    private String div_radio;
    @NotEmpty
    private String fileToUpload1;
    @NotEmpty
    private String fileToUpload2;
    private String fileToUpload;
    private String fileToUpload3;

    /**
     * @return the div_radio
     */
    public String getDiv_radio() {
        return div_radio;
    }

    /**
     * @param div_radio the div_radio to set
     */
    public void setDiv_radio(String div_radio) {
        this.div_radio = div_radio;
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
     * @return the fileToUpload2
     */
    public String getFileToUpload2() {
        return fileToUpload2;
    }

    /**
     * @param fileToUpload2 the fileToUpload2 to set
     */
    public void setFileToUpload2(String fileToUpload2) {
        this.fileToUpload2 = fileToUpload2;
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
     * @return the fileToUpload3
     */
    public String getFileToUpload3() {
        return fileToUpload3;
    }

    /**
     * @param fileToUpload3 the fileToUpload3 to set
     */
    public void setFileToUpload3(String fileToUpload3) {
        this.fileToUpload3 = fileToUpload3;
    } 
}  