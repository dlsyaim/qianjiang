package com.ks.qianjiang.Util;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class DESUtil {
    public static  String encodeMd5(String str){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getCause()+e.getMessage());
        }
        byte[] result=md.digest(str.getBytes(Charset.forName("UTF-8")));

        StringBuffer sb=new StringBuffer();
        for(int i=0;i<result.length;i++){
            String tmp= StringUtils.leftPad(String.format("%X", result[i]), 2,'0');
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static String encodeString(String str) throws IOException
    {
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        String encodedStr = new String(encoder.encodeBuffer(str.getBytes()));
        return encodedStr.trim();
    }

    public static String getRandomString(int length){
        //1.  定义一个字符串（A-Z，a-z，0-9）即62个数字字母；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //2.  由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //3.  长度为几就循环几次
        for(int i=0; i<length; ++i){
            //从62个的数字或字母中选择
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

}
