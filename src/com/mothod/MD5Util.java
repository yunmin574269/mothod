package com.mothod;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 */
public class MD5Util {

    public static String getMD5(String str) {
        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }

    public static String  twiceMD5(String str){
        return getMD5(getMD5(str));
    }
    public static String cookieEncipherment(String s){
        StringBuffer sb = new StringBuffer();
        for(int i =0;i< s.length(); i++){

        }
        return  null;
    }

    public static void main(String[] args) {
        String s = twiceMD5("99999999");
        System.out.println(s+"--length="+s.length() );
    }

}
