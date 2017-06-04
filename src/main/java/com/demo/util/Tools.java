package com.demo.util;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * Created by richard on 2017/6/4.
 */
public class Tools {
    public static String md5(String str){
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("utf-8"));
            final byte[] resultByte = messageDigest.digest();
            String result = Hex.encodeHexString(resultByte);
            return result.toUpperCase();
        }catch (Exception e){

        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(md5("test"));
    }
}
