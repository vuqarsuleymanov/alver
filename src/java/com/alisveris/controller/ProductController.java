/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alisveris.controller;

import com.alisveris.DBOperations;
import com.alisveris.pojo.Brand;
import com.alisveris.pojo.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author User
 */
@ManagedBean(name="ctrProduct")
@RequestScoped
public class ProductController implements Serializable{
    DBOperations db = new DBOperations();
    private List<Product> listProduct = new ArrayList<Product>();
    private List<Brand> listBrand = new ArrayList<Brand>();
    private List<Product> listProductAjaxArtir = new ArrayList<Product>();
    int count = 0;
    public List<Brand> getListBrand() {
        listBrand.clear();
        for(Brand b : db.brandList()){
        
            b.getBrand_id();
            b.getBrand_image();
            b.getBrand_name();
            b.getBrand_status();
            b.getBrand_link();
            listBrand.add(b);
        }
        return listBrand;
    }

    public void setListBrand(List<Brand> listBrand) {
        this.listBrand = listBrand;
    }
    
    public List<Product> getListProduct() {
        listProduct.clear();
        for(Product p : db.productList()){
            p.getId();
            p.getTitle();
            p.getShort_article();
            p.getArticle();
            p.getPrice();
            p.getRaiting();
            p.getImage();
            listProduct.add(p);
        }
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }
    
    
    
}
