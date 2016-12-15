/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Property;
import java.io.Serializable;

/**
 *
 * @author Sentinel
 */
public class PropertyDTO implements Serializable{
    private Property p;

    public PropertyDTO() {
        p = new Property();
    }

    public PropertyDTO(Property p) {
        this.p = p;
    }

    public void setProperty(Property p) {
        this.p = p;
    }

    public Property getProperty() {
        return p;
    }
    
    public String getKey() {
        return p.getKey();
    }

    public void setKey(String key) {
        this.p.setKey(key);
    }

    public String getValue() {
        return p.getValue();
    }

    public void setValue(String value) {
        this.p.setValue(value);
    }
}
