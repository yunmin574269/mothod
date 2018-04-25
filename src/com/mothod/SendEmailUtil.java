package com.mothod;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

/** 发送邮件 */
public class SendEmailUtil {

    private final static  String SERVICE_HOST = "smtp.qq.com";//QQ服务器

    private final static  int    PORT = 465; //smtp的端口号

    private final static  String PROTOCOL = "smtp"; //协议名称。smtp表示简单邮件传输协议

    private final static  String ACCOUNT = "347594248@qq.com"; //发送邮件的QQ账号

    private final static  String AUTH_CODE = "fjnftxpktdthbjba"; //QQ授权码(需要到https://mail.qq.com/申请)

    private static final JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

    /*

     *发送QQ邮件的初始化配置

     */

    static{

        senderImpl.setHost(SERVICE_HOST); //设置 使用QQ邮箱发送邮件的主机名

        senderImpl.setPort(PORT); //设置端口号

        senderImpl.setProtocol(PROTOCOL); //协议名称

        senderImpl.setUsername(ACCOUNT); // 设置自己的邮箱帐号名称

        senderImpl.setPassword(AUTH_CODE); // 设置对应账号申请到的授权码

        Properties prop = new Properties();

        prop.put(" mail.smtp.auth ", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确

        prop.put("mail.smtp.starttls.enable", "true");

        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //使用ssl协议来保证连接安全

        prop.put(" mail.smtp.timeout ", "25000"); //传输超时时间

        senderImpl.setJavaMailProperties(prop);

    }

    /**

     * 发送简单邮件

     * @param account  被发邮件的用户

     * @param info      邮件信息

     * @param title     邮件主题

     */

    public static void sendSimpleMail(String account,String info,String title){

        //创建简单邮件对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(account);  //设置邮件接收者账号

        mailMessage.setFrom(ACCOUNT); //设置邮件的发送者

        mailMessage.setSubject(title);//设置邮件的主题

        mailMessage.setText(info);    //设置邮件的内容

        //发送邮件
        senderImpl.send(mailMessage);

    }

    /**

     * 函数入口（主要用于shell调用）

     * @param args  有三个参数，分别是文件名（主要是邮箱账户），邮件主题  和邮件内容

     */

    public static void main(String args[])

    {
        //实例化一个random的对象ne
        Random ne=new Random();
        //为变量赋随机值1000-9999
        int x=ne.nextInt(9999-1000+1)+1000;
        sendSimpleMail("347594248@qq.com","验证码："+x,"邮件验证码");
        System.out.println(" 邮件发送成功.. ");

    }


}

