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
public class Brand implements Serializable{
    
    private Integer brand_id;
    private String brand_name;
    private String brand_image;
    private String brand_status;
    private String brand_link;
    private String insert_date;

    public Brand() {
    }

    public Brand(Integer brand_id, String brand_name, String brand_image, String brand_status, String brand_link, String insert_date) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.brand_image = brand_image;
        this.brand_status = brand_status;
        this.brand_link = brand_link;
        this.insert_date = insert_date;
    }
    
    

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
    }
    
    

    public String getBrand_link() {
        return brand_link;
    }

    public void setBrand_link(String brand_link) {
        this.brand_link = brand_link;
    }
    
    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_image() {
        return brand_image;
    }

    public void setBrand_image(String brand_image) {
        this.brand_image = brand_image;
    }

    public String getBrand_status() {
        return brand_status;
    }

    public void setBrand_status(String brand_status) {
        this.brand_status = brand_status;
    }
}
