/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.domain;


/**
 *
 * @author SAP Training
 */
public class Cookie {
    private Integer id;
    private String ipAddress;
    private String jsonDoc;
    private String hashed;
    private String name;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the jsonDoc
     */
    public String getJsonDoc() {
        return jsonDoc;
    }

    /**
     * @param jsonDoc the jsonDoc to set
     */
    public void setJsonDoc(String jsonDoc) {
        this.jsonDoc = jsonDoc;
    }
     /**
     * @return the hashed
     */
    public String getHashed() {
        return hashed;
    }

    /**
     * @param hashed the hashed to set
     */
    public void setHashed(String hashed) {
        this.hashed = hashed;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
