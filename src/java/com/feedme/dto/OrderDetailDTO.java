/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Employee;
import com.feedme.entities.OrderDetail;
import com.feedme.entities.OrderStatus;
import com.feedme.info.Information;
import com.feedme.utils.Json;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giang
 */
public class OrderDetailDTO implements Serializable{
    private OrderDetail o;

    public OrderDetailDTO() {
        o = new OrderDetail();
    }

    public OrderDetailDTO(OrderDetail o) {
        this.o = o;
    }

    public OrderDetail getOrderDetail() {
        return o;
    }

    public void setOrderDetail(OrderDetail o) {
        this.o = o;
    }
    
    public Integer getId() {
        return o.getId();
    }

    public void setId(int id) {
        o.setId(id);
    }

    public Information getCustomer() {
        try {
            return Json.DeserializeObject(o.getCustomer(), Information.class);
        } catch (Exception ex) {
            return new Information();
        }
    }

    public void setCustomer(Information customer) {
        try {
            o.setCustomer(Json.SerializeObject(customer));
        } catch (Exception ex) {
        }
    }

    public Information getNote() {
        try {
            return Json.DeserializeObject(o.getNote(), Information.class);
        } catch (Exception ex) {
            return new Information();
        }
    }

    public void setNote(String note) {
        try {
            o.setNote(Json.SerializeObject(note));
        } catch (Exception ex) {
        }
    }

    public String getOrdertime() {
        return o.getOrdertime();
    }

    public void setOrdertime(String ordertime) {
        o.setOrdertime(ordertime);
    }

    public List<ProductDTO> getFoods() {
        try {
            return Json.DeserializeObject(o.getFoods(), List.class);
        } catch (Exception ex) {
            return null;
        }
    }

    public void setFoods(List<ProductDTO> foods) {
        try {
            o.setFoods(Json.SerializeObject(foods));
        } catch (Exception ex) {
        }
    }

    public Double getSubtotal() {
        return o.getSubtotal();
    }

    public void setSubtotal(Double subtotal) {
        o.setSubtotal(subtotal);
    }

    public double getDiscount() {
        return o.getDiscount();
    }

    public void setDiscount(double discount) {
        o.setDiscount(discount);
    }

    public Double getRating() {
        return o.getRating();
    }

    public void setRating(Double rating) {
        o.setRating(rating);
    }

    public String getComment() {
        return o.getComment();
    }

    public void setComment(String comment) {
        o.setComment(comment);
    }

    public EmployeeDTO getEmployee() {
        return new EmployeeDTO(o.getEmployee());
    }

    public void setEmployee(EmployeeDTO employee) {
        o.setEmployee(employee.getEmployee());
    }

    public OrderStatusDTO getStatus() {
        return new OrderStatusDTO(o.getStatus());
    }

    public void setStatus(OrderStatusDTO status) {
        o.setStatus(status.getOrderStatus());
    }
}
