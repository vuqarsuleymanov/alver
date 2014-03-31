/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alisveris.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class ValidateController implements Serializable{
    private String name;
    private String validateName;
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    

    public String getValidateName() {
        return validateName;
    }

    public void setValidateName(String validateName) {
        this.validateName = validateName;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public String check(){
    if(getName().length()<3){
        setValidateName("Dogru isim giriniz");
        return null;
    }else{
        setValidateName("");
       return "home";
    }
    }
    
    
}
