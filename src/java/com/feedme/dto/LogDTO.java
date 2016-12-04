/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Log;
import java.io.Serializable;

/**
 *
 * @author Giang
 */
public class LogDTO implements Serializable{
    private Log l;

    public LogDTO() {
    }

    public LogDTO(Log l) {
        this.l = l;
    }

    public Log getLog() {
        return l;
    }

    public void setLog(Log l) {
        this.l = l;
    }
    
    public Integer getId() {
        return l.getId();
    }

    public void setId(Integer id) {
        l.setId(id);
    }

    public String getTitle() {
        return l.getTitle();
    }

    public void setTitle(String title) {
        l.setTitle(title);
    }

    public float getRatingAvg() {
        return l.getRatingAvg();
    }

    public void setRatingAvg(float ratingAvg) {
        l.setRatingAvg(ratingAvg);
    }

    public int getTotalOrders() {
        return l.getTotalOrders();
    }

    public void setTotalOrders(int totalOrders) {
        l.setTotalOrders(totalOrders);
    }

    public double getTtoalIncome() {
        return l.getTtoalIncome();
    }

    public void setTtoalIncome(double ttoalIncome) {
        l.setTtoalIncome(ttoalIncome);
    }

    public EmployeeDTO getEmployee() {
        return new EmployeeDTO(l.getEmployee());
    }

    public void setEmployee(EmployeeDTO employee) {
        l.setEmployee(employee.getEmployee());
    }
    
    public String getTimestamp() {
        return l.getTimestamp();
    }

    public void setTimestamp(long timestamp) {
        l.setTimestamp(timestamp+"");
    }
}
