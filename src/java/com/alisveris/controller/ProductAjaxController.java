/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alisveris.controller;

import com.alisveris.DBOperations;
import com.alisveris.pojo.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */
@ManagedBean(name = "cajax")
@SessionScoped

public class ProductAjaxController implements Serializable{

    private String selectedCriteria="insert_date";
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    DBOperations db = new DBOperations();
    private List<Product> listProductAjaxArtir = new ArrayList<Product>();
    private List<Product> listProductPrice = new ArrayList<Product>();

    public List<Product> getListProductPrice() {
         listProductPrice.clear();
        for(Product p : db.productListByPriceDesc(getSelectedCriteria(), count)){
            System.out.println(getSelectedCriteria());
            p.getId();
            p.getTitle();
            p.getShort_article();
            p.getArticle();
            p.getPrice();
            p.getRaiting();
            p.getImage();
            listProductPrice.add(p);
        }
       
        
        return listProductPrice;
    }

    public void setListProductPrice(List<Product> listProductPrice) {
        this.listProductPrice = listProductPrice;
    }
    int count = 4;
    
    public String getSelectedCriteria() {
        return selectedCriteria;
    }

    public void setSelectedCriteria(String selectedCriteria) {
        this.selectedCriteria = selectedCriteria;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    public List<Product> getListProductAjaxArtir() {
          listProductAjaxArtir.clear();
        for(Product p : db.productListNextPrevious(count)){
            p.getId();
            p.getTitle();
            p.getShort_article();
            p.getArticle();
            p.getPrice();
            p.getRaiting();
            p.getImage();
            listProductAjaxArtir.add(p);
        }
       
        return listProductAjaxArtir;
    }

    public void setListProductAjaxArtir(List<Product> listProductAjaxArtir) {
        this.listProductAjaxArtir = listProductAjaxArtir;
    }
    
      public void artir(){
          setCount(count+=4);
    }
     
  
}
