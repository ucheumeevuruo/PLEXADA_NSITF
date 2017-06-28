/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.model.impl;

/**
 *
 * @author SAP Training
 */
public interface Address {
    public void setHouseNo(String houseNo);
    public void setStreetName(String streetName);
    public void setCity(String city);
    public void setProvince(String province);
    public void setState(String state);
    public void setCountry(String country);
    public String getHouseNo();
    public String getStreetName();
    public String getCity();
    public String getProvince();
    public String getState();
    public String getCountry();
}
