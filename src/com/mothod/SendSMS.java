package com.mothod;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class SendSMS {

    public static String SendSMS(String phone, String code) throws IOException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", "yunmin574269"),new NameValuePair("Key", "8af0bf602d42ebc2bd47"),new NameValuePair("smsMob",phone),new NameValuePair("smsText","验证码："+code+",有效时间：5分钟")};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
/*        System.out.println("statusCode:"+statusCode);*/
/*        for(Header h : headers)
        {
            System.out.println(h.toString());
        }*/
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
/*        System.out.println(result); //打印返回消息状态*/


        post.releaseConnection();



        return result;
    }

    public static void main(String agrs[]){
        try {
            SendSMS("15351930920","5478");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
