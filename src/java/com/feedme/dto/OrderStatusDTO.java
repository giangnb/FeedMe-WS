/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.OrderStatus;
import java.io.Serializable;

/**
 *
 * @author havietduc
 */
public class OrderStatusDTO implements Serializable{
    private OrderStatus os;

    public OrderStatusDTO() {
        os = new OrderStatus(); 
    }
    
    public OrderStatusDTO(OrderStatus os){
        this.os = os;
    }
     
    public OrderStatus getOrderStatus() {
        return os;
    }
    public Short getId() {
        return os.getId();
    }

    public void setId(int id) {
      try{
         os.setId(Short.parseShort(id+""));
      }
      catch(Exception ex){
      
      }
    }

    public String getName() {
        return os.getName();
    }

    public void setName(String name) {
       this.os.setName(name);
    }

    public boolean getIsStopped() {
        return os.getIsStopped();
    }

    public void setIsStopped(boolean isStopped) {
      this.os.setIsStopped(isStopped);
    }

     
}
