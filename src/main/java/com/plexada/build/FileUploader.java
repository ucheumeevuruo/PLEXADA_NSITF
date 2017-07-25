/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SAP Training
 */
public class FileUploader {
    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "c://temp//";
    private static String getFileName;
    private static Byte[] getByte;
    
    //save file
    public static List<byte[]> saveUploadedFiles(List<MultipartFile> files) throws IOException {
        List<byte[]> list = new ArrayList();
        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }
            list.add(file.getBytes());
        }
        return list;
    }
    
    public static String generateBase64Image(byte binaryData[]){
        return Base64.encodeBase64String(binaryData);
    }
    
    public static byte[] getImageAsBytes(BufferedImage buffer) throws IOException{
        byte[] imageInByte;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(buffer, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
        }
        return imageInByte;

    }
}
