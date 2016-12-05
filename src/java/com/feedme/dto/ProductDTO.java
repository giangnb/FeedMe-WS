/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Category;
import java.io.Serializable;

/**
 *
 * @author havietduc
 */
public class ProductDTO implements Serializable{
    private Short id;
    private String name;
    private String description;
    private double price;
    private String promotion;
    private String info;
    private boolean isActive;
    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(Short id, String name, String description, double price, String promotion, String info, boolean isActive, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.promotion = promotion;
        this.info = info;
        this.isActive = isActive;
        this.category = category;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
}
