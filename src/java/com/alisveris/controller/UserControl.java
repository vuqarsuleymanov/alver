/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alisveris.controller;

import com.alisveris.DBOperations;
import com.alisveris.pojo.User;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
@ManagedBean(name="user")
@RequestScoped

public class UserControl {
    
    DBOperations db = new DBOperations();
   
    private String f_name;
    private String l_name;
    private String m_name;
    private String password;
    private String tel;
    private String email;
    private String company;
    private String first_address;
    private String second_address;
    private String city;
    private String post_code;
    private String region;
    private String active;
    private String user_code;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFirst_address() {
        return first_address;
    }

    public void setFirst_address(String first_address) {
        this.first_address = first_address;
    }

    public String getSecond_address() {
        return second_address;
    }

    public void setSecond_address(String second_address) {
        this.second_address = second_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String insertUserr(){
    
        User user = new User();
        user.setF_name(f_name);
        user.setL_name(l_name);
        user.setM_name(m_name);
        user.setEmail(email);
        user.setTel(tel);
        user.setCity(city);
        user.setFirst_address(first_address);
        user.setCompany(company);
        user.setSecond_address(second_address);
        user.setPassword(password);
        user.setPost_code(post_code);
        user.setRegion(region);
       db.insertUser(user);
       String userCode = db.searchUserCode(email);
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("orkhan.mirzayev34@gmail.com", "34MRZ34AAOtogetherwith");
                
            }
});
        try {
            String text ="<div style='color:red'><a href='http://localhost:16546/Alisveris/faces/activation.jsp?code="+userCode+"'>Gonder</a></div>";
            MimeMessage message = new MimeMessage(session);
            
            message.setText(text, "utf-8", "html");
            message.addRecipients(Message.RecipientType.TO,  InternetAddress.parse("orkhan.mirzayev34@gmail.com"));
            message.setSubject("Test");
           
           
            Transport.send(message);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
     return "home";
    }
    
    public void checkEmail(){
        String filter = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
       
        if(checkPattern() && db.checkEmail(email)){
            setValue("bu email artiq qeydiyatdan kecib");
        }else if(checkPattern()){
            setValue("");
        }
    }
    
    public boolean checkPattern(){
    
        String filter = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
           
           Pattern pt = Pattern.compile(filter);
           Matcher m = pt.matcher(email);
           if(m.find()){
               return true;
           }
           else{
           return false;}
           
    
    }
    }


    

