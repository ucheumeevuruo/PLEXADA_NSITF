/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.digest.DigestUtils;
import org.testng.annotations.Test;

/**
 *
 * @author SAP Training
 */
public class HashAlgorithm {
    private static String md5Hex;
    
    @Test
    public static String hashingUsingBind(String stringToHash) 
      throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(stringToHash.getBytes());
        byte[] digest = md.digest();
        md5Hex = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return md5Hex;
    }
    
    @Test
    public static String hashingUsingCommons(String stringToHash)  {
        md5Hex = DigestUtils.md5Hex(stringToHash).toUpperCase();
        return md5Hex;
    }
    
    public static boolean assertThat(String checkSum, String hash){
        return checkSum.equals(hash);
    }
}
