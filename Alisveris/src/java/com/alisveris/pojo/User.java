/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alisveris.pojo;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class User implements Serializable{
    private int id;
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

    public User() {
    }

    public User(int id, String f_name, String l_name, String m_name, String password, String tel, String email, String company, String first_address, String second_address, String city, String post_code, String region, String active, String user_code) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.m_name = m_name;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.company = company;
        this.first_address = first_address;
        this.second_address = second_address;
        this.city = city;
        this.post_code = post_code;
        this.region = region;
        this.active = active;
        this.user_code = user_code;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
}
