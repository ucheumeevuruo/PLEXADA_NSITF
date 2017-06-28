/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.plexada.build.JsonFileMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.lang.reflect.Type;

/**
 *
 * @author SAP Training
 */
public class JsonObjectRepository {
    private Map<String, Object> mapper;
    private FileReader fileReader;
    private FileWriter fileWriter;
    
    // Initialize the repository
    // Not necessary when saving to repository
    public JsonObjectRepository initRepo(Type listType) throws FileNotFoundException, IOException{
        // Retrieve file from temporal file system directory.
        fileReader = new FileReader(tempFileDirectory());
        mapper = JsonFileMapper.getJsonMap(fileReader, listType);
        //fileReader.close();
        return this;
    }
    
    public Map findAll(){
        return mapper;
    }
    
    public <T>Object findByObjectId(String object){
        return mapper.get(object);
    }
    
    public boolean contains(String k){
        return mapper.containsKey(k);
    }
    
    public void save(Map<? extends String, ? extends Object> map) throws IOException{
        fileWriter = new FileWriter(tempFileDirectory());
        JsonFileMapper.storeJson(map, fileWriter);
        fileWriter.close();
    }
    
    private String tempFileDirectory(){
        return "C:\\temp\\test.json";
    }
}
