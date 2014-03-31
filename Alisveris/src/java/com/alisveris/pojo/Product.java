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
public class Product implements Serializable{
    private int id;
    private String title;
    private String short_article;
    private String article;
    private double price;
    private int raiting;
    private String image;
    private String status;
    private String insert_date;

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
    }
    
    

    public Product() {
    }

    public Product(int id, String title, String short_article, String article, double price, int raiting, String image, String status, String insert_date) {
        this.id = id;
        this.title = title;
        this.short_article = short_article;
        this.article = article;
        this.price = price;
        this.raiting = raiting;
        this.image = image;
        this.status = status;
        this.insert_date = insert_date;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_article() {
        return short_article;
    }

    public void setShort_article(String short_article) {
        this.short_article = short_article;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
