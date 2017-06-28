/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SAP Training
 */
public class JsonFileMapper {
    private static Gson gson = new Gson();
    private static Map<String, Object> mapper = new HashMap();
    
    public JsonFileMapper(){
    }
    
    public static JsonObject getJsonObject(FileReader file){
        return gson.fromJson(file, JsonObject.class);
    }
    
    public static <T> Map<String, T> getJsonMap(FileReader fileReader, Type listType){
        return gson.fromJson(fileReader, listType);
    }
    
    public static <T> Map<String, T> getJsonMap(JsonObject fileReader, Type listType){
        return gson.fromJson(fileReader, listType);
    }
    
    public static void storeJson(Map<? extends String, ? extends Object> map, FileWriter writer){
        mapper.putAll(map);
        gson.toJson(mapper, writer);
    }
}
