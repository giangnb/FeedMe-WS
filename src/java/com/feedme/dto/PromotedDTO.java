/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Promoted;
import java.io.Serializable;

/**
 *
 * @author Sentinel
 */
public class PromotedDTO implements Serializable{
     private Promoted p;

    public PromotedDTO(Promoted p) {
        this.p = p;
    }

    public void setPromoted(Promoted p) {
        this.p = p;
    }

    public Promoted getPromoted() {
        return p;
    }
    
    public PromotedDTO() {
        p = new Promoted();
    }
    
     public Integer getId() {
        return p.getId();
    }

    public void setId(Integer id) {
        this.p.setId(id);
    }

    public String getFromTime() {
        return p.getFromTime();
    }

    public void setFromTime(String fromTime) {
        this.p.setFromTime(fromTime);
    }

    public String getToTime() {
        return p.getToTime();
    }

    public void setToTime(String toTime) {
        this.p.setToTime(toTime);
    }

    public ProductDTO getProduct() {
        return new ProductDTO(p.getProduct());
    }
    
    public void setProduct(ProductDTO productDto) {
        this.p.setProduct(productDto.getProduct());
    }
}
