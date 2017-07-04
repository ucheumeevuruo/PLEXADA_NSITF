/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.plexada.services.DBCookieService;
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
    private final DBCookieService cookieService = (DBCookieService) context.getBean("cookieDOA");
    private Cookie cookie = null;
    Gson gson = new Gson();
    
    public JsonDBRepository(Cookie cookie){
        this.cookie = cookie;
    }
    
    // Initialize the repository
    // Not necessary when saving to repository
    public JsonDBRepository initRepo(Type listType) throws Exception{
        // Retrieve file from temporal file system directory.
        List<Cookie> list = cookieService.findByIP(cookie);
        if(list.isEmpty()){
            throw new Exception(list.toString());
        }
        mapper = gson.fromJson(list.get(0).getJsonDoc(), listType);
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
        if(cookieService.findTotalCustomer(cookie) == 0){
            String json = gson.toJson(map);
            cookie.setJsonDoc(json); 
            cookieService.create(cookie);
        }else{
            try {
                Cookie temp = cookie;
                this.initRepo( new TypeToken<Map<String, Object>>(){}.getType());
                //Maps.difference(map, mapper).entriesOnlyOnLeft()
                mapper.putAll(map);
                String json = gson.toJson(mapper);
                cookie = temp;
                cookie.setJsonDoc(json);
                cookieService.update(cookie);
            } catch (Exception ex) {}
        }
    }

    public void delete() {
        cookieService.delete(cookie);
        System.out.println(cookie.getHashed());
        System.out.println(cookie.getIpAddress());
        System.out.println(cookie.getName());
    }
}
