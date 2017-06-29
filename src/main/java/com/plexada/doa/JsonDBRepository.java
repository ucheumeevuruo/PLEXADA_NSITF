/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.plexada.build.JsonFileMapper;
import com.plexada.services.DBCookieService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.lang.reflect.Type;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.plexada.model.Cookie;
import java.util.List;

/**
 *
 * @author SAP Training
 */
public class JsonDBRepository {
    private Map<String, Object> mapper;
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    private final DBCookieService cookies = (DBCookieService) context.getBean("cookieDOA");
    Gson gson = new Gson();
    
    // Initialize the repository
    // Not necessary when saving to repository
    public JsonDBRepository initRepo(Type listType) throws Exception{
        // Retrieve file from temporal file system directory.
        List<Cookie> list = cookies.findById("1");
        if(list.isEmpty()){
            throw new Exception(list.toString());
        }
        Cookie cookie = list.get(0);
        mapper = gson.fromJson(cookie.getJsonDoc(), listType);
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
    
    public void save(Map<? extends String, ? extends Object> map){
        String json = gson.toJson(map);
        Cookie cookie = new Cookie();
        cookie.setId(1);
        cookie.setIp_address("192.168.3.10");
        cookie.setJsonDoc(json);
        System.out.print(cookie.getJsonDoc());
        cookies.create(cookie);
        //cookies.update(cookie);
    }
}
