/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Category;
import com.feedme.entities.Product;
import java.io.Serializable;

/**
 *
 * @author havietduc
 */
public class ProductDTO implements Serializable{
    private Product p;

    public ProductDTO() {
        p = new Product();
    }

    public ProductDTO(Product p) {
        this.p = p;
    }
    
    public Product getProduct(){
       return p;
    }
    
     public Short getId() {
        return p.getId();
    }

    public void setId(Short id) {
        this.p.setId(id);
    }

    public String getName() {
        return p.getName();
    }

    public void setName(String name) {
        this.p.setName(name);
    }

    public String getDescription() {
        return p.getDescription();
    }

    public void setDescription(String description) {
        this.p.setDescription(description);
    }

    public double getPrice() {
        return p.getPrice();
    }

    public void setPrice(double price) {
        this.p.setPrice(price);
    }

    public String getPromotion() {
        return p.getPromotion();
    }

    public void setPromotion(String promotion) {
        this.p.setPromotion(promotion);
    }

    public String getInfo() {
        return p.getInfo();
    }

    public void setInfo(String info) {
        this.p.setInfo(info);
    }

    public boolean getIsActive() {
        return p.getIsActive();
    }

    public void setIsActive(boolean isActive) {
        this.p.setIsActive(isActive);
    }

    public CategoryDTO getCategory() {
        return new CategoryDTO(p.getCategory());
    }

    public void setCategory(CategoryDTO categoryDTO) {
        this.p.setCategory(categoryDTO.getCategory());
    }
}
