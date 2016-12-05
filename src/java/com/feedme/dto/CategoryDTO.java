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
 * @author Giang
 */
public class CategoryDTO implements Serializable{
    private Category c;

    public CategoryDTO() {
        c = new Category();
    } 

    public CategoryDTO(Category c) {
        this.c = c;
    }

    public Category getCategory() {
        return c;
    }

    public void setCategory(Category c) {
        this.c = c;
    }
    
    public Short getId() {
        return c.getId();
    }

    public void setId(int id) {
        try {
            c.setId(Short.parseShort(id+""));
        } catch (Exception ex) {}
    }

    public String getName() {
        return c.getName();
    }

    public void setName(String name) {
        c.setName(name);
    }

    public String getDescription() {
        return c.getDescription();
    }

    public void setDescription(String description) {
        c.setDescription(description);
    }
}
