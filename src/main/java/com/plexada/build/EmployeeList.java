/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SAP Training
 */
public class EmployeeList {
    private MultipartFile list;
    private List<byte[]> file = new ArrayList();
    
        /**
     * @return the list
     */
    public MultipartFile getList() {
        return list;
    }

    /**
     * @param list the stamp to set
     */
    public void setImages(MultipartFile list) {
        this.list = list;
    }
    
     public List<byte[]> getFile(){
        return this.file;
    }
    
    public void setFile(List<byte[]> file){
        this.file = file;
    }
}
