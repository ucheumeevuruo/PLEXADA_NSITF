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
public class NODAccident {
    @NotEmpty
    private String workNature;
    @NotEmpty
    private String diseaseNature;
    @NotEmpty
    private String state;
    @NotEmpty
    private String province;
    @NotEmpty
    private String cod;
    @NotEmpty
    private String reportDate;
    @NotEmpty
    private String reportTime;
    @NotEmpty
    private String diagnosisDate;
    @NotEmpty
    private String length;
    @NotEmpty
    private String ceaseDate;
    @NotEmpty
    private String resumeDate;
    @NotEmpty
    private String numDay;
    @NotEmpty
    private String medicFirstName;
    @NotEmpty
    private String medicLastName;
    @NotEmpty
    private String practiceNumber;
    @NotEmpty
    private String kinFirstName;
    @NotEmpty
    private String kinLastName;
    @NotEmpty
    private String dFirstName;
    private String dMiddleName;
    @NotEmpty
    private String dLastName;
    @NotEmpty
    private String dDob;
    @NotEmpty
    private String dFirstName2;
    private String dMiddleName2;
    @NotEmpty
    private String dLastName2;
    @NotEmpty
    private String dDob2;
    @NotEmpty
    private String dFirstName3;
    private String dMiddleName3;
    @NotEmpty
    private String dLastName3;
    @NotEmpty
    private String dDob3;
    @NotEmpty
    private String dFirstName4;
    private String dMiddleName4;
    @NotEmpty
    private String dLastName4;
    @NotEmpty
    private String dDob4;   

    /**
     * @return the workNature
     */
    public String getWorkNature() {
        return workNature;
    }

    /**
     * @param workNature the workNature to set
     */
    public void setWorkNature(String workNature) {
        this.workNature = workNature;
    }

    /**
     * @return the diseaseNature
     */
    public String getDiseaseNature() {
        return diseaseNature;
    }

    /**
     * @param diseaseNature the diseaseNature to set
     */
    public void setDiseaseNature(String diseaseNature) {
        this.diseaseNature = diseaseNature;
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
     * @return the cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return the reportDate
     */
    public String getReportDate() {
        return reportDate;
    }

    /**
     * @param reportDate the reportDate to set
     */
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * @return the reportTime
     */
    public String getReportTime() {
        return reportTime;
    }

    /**
     * @param reportTime the reportTime to set
     */
    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * @return the diagnosisDate
     */
    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    /**
     * @param diagnosisDate the diagnosisDate to set
     */
    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    /**
     * @return the length
     */
    public String getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * @return the ceaseDate
     */
    public String getCeaseDate() {
        return ceaseDate;
    }

    /**
     * @param ceaseDate the ceaseDate to set
     */
    public void setCeaseDate(String ceaseDate) {
        this.ceaseDate = ceaseDate;
    }

    /**
     * @return the resumeDate
     */
    public String getResumeDate() {
        return resumeDate;
    }

    /**
     * @param resumeDate the resumeDate to set
     */
    public void setResumeDate(String resumeDate) {
        this.resumeDate = resumeDate;
    }

    /**
     * @return the numDay
     */
    public String getNumDay() {
        return numDay;
    }

    /**
     * @param numDay the numDay to set
     */
    public void setNumDay(String numDay) {
        this.numDay = numDay;
    }

    /**
     * @return the medicFirstName
     */
    public String getMedicFirstName() {
        return medicFirstName;
    }

    /**
     * @param medicFirstName the medicFirstName to set
     */
    public void setMedicFirstName(String medicFirstName) {
        this.medicFirstName = medicFirstName;
    }

    /**
     * @return the medicLastName
     */
    public String getMedicLastName() {
        return medicLastName;
    }

    /**
     * @param medicLastName the medicLastName to set
     */
    public void setMedicLastName(String medicLastName) {
        this.medicLastName = medicLastName;
    }

    /**
     * @return the practiceNumber
     */
    public String getPracticeNumber() {
        return practiceNumber;
    }

    /**
     * @param practiceNumber the practiceNumber to set
     */
    public void setPracticeNumber(String practiceNumber) {
        this.practiceNumber = practiceNumber;
    }

    /**
     * @return the kinFirstName
     */
    public String getKinFirstName() {
        return kinFirstName;
    }

    /**
     * @param kinFirstName the kinFirstName to set
     */
    public void setKinFirstName(String kinFirstName) {
        this.kinFirstName = kinFirstName;
    }

    /**
     * @return the kinLastName
     */
    public String getKinLastName() {
        return kinLastName;
    }

    /**
     * @param kinLastName the kinLastName to set
     */
    public void setKinLastName(String kinLastName) {
        this.kinLastName = kinLastName;
    }

    /**
     * @return the dFirstName
     */
    public String getdFirstName() {
        return dFirstName;
    }

    /**
     * @param dFirstName the dFirstName to set
     */
    public void setdFirstName(String dFirstName) {
        this.dFirstName = dFirstName;
    }

    /**
     * @return the dMiddleName
     */
    public String getdMiddleName() {
        return dMiddleName;
    }

    /**
     * @param dMiddleName the dMiddleName to set
     */
    public void setdMiddleName(String dMiddleName) {
        this.dMiddleName = dMiddleName;
    }

    /**
     * @return the dLastName
     */
    public String getdLastName() {
        return dLastName;
    }

    /**
     * @param dLastName the dLastName to set
     */
    public void setdLastName(String dLastName) {
        this.dLastName = dLastName;
    }

    /**
     * @return the dDob
     */
    public String getdDob() {
        return dDob;
    }

    /**
     * @param dDob the dDob to set
     */
    public void setdDob(String dDob) {
        this.dDob = dDob;
    }

    /**
     * @return the dFirstName2
     */
    public String getdFirstName2() {
        return dFirstName2;
    }

    /**
     * @param dFirstName2 the dFirstName2 to set
     */
    public void setdFirstName2(String dFirstName2) {
        this.dFirstName2 = dFirstName2;
    }

    /**
     * @return the dMiddleName2
     */
    public String getdMiddleName2() {
        return dMiddleName2;
    }

    /**
     * @param dMiddleName2 the dMiddleName2 to set
     */
    public void setdMiddleName2(String dMiddleName2) {
        this.dMiddleName2 = dMiddleName2;
    }

    /**
     * @return the dLastName2
     */
    public String getdLastName2() {
        return dLastName2;
    }

    /**
     * @param dLastName2 the dLastName2 to set
     */
    public void setdLastName2(String dLastName2) {
        this.dLastName2 = dLastName2;
    }

    /**
     * @return the dDob2
     */
    public String getdDob2() {
        return dDob2;
    }

    /**
     * @param dDob2 the dDob2 to set
     */
    public void setdDob2(String dDob2) {
        this.dDob2 = dDob2;
    }

    /**
     * @return the dFirstName3
     */
    public String getdFirstName3() {
        return dFirstName3;
    }

    /**
     * @param dFirstName3 the dFirstName3 to set
     */
    public void setdFirstName3(String dFirstName3) {
        this.dFirstName3 = dFirstName3;
    }

    /**
     * @return the dMiddleName3
     */
    public String getdMiddleName3() {
        return dMiddleName3;
    }

    /**
     * @param dMiddleName3 the dMiddleName3 to set
     */
    public void setdMiddleName3(String dMiddleName3) {
        this.dMiddleName3 = dMiddleName3;
    }

    /**
     * @return the dLastName3
     */
    public String getdLastName3() {
        return dLastName3;
    }

    /**
     * @param dLastName3 the dLastName3 to set
     */
    public void setdLastName3(String dLastName3) {
        this.dLastName3 = dLastName3;
    }

    /**
     * @return the dDob3
     */
    public String getdDob3() {
        return dDob3;
    }

    /**
     * @param dDob3 the dDob3 to set
     */
    public void setdDob3(String dDob3) {
        this.dDob3 = dDob3;
    }

    /**
     * @return the dFirstName4
     */
    public String getdFirstName4() {
        return dFirstName4;
    }

    /**
     * @param dFirstName4 the dFirstName4 to set
     */
    public void setdFirstName4(String dFirstName4) {
        this.dFirstName4 = dFirstName4;
    }

    /**
     * @return the dMiddleName4
     */
    public String getdMiddleName4() {
        return dMiddleName4;
    }

    /**
     * @param dMiddleName4 the dMiddleName4 to set
     */
    public void setdMiddleName4(String dMiddleName4) {
        this.dMiddleName4 = dMiddleName4;
    }

    /**
     * @return the dLastName4
     */
    public String getdLastName4() {
        return dLastName4;
    }

    /**
     * @param dLastName4 the dLastName4 to set
     */
    public void setdLastName4(String dLastName4) {
        this.dLastName4 = dLastName4;
    }

    /**
     * @return the dDob4
     */
    public String getdDob4() {
        return dDob4;
    }

    /**
     * @param dDob4 the dDob4 to set
     */
    public void setdDob4(String dDob4) {
        this.dDob4 = dDob4;
    }
}  