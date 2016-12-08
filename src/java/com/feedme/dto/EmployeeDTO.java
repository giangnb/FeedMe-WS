/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Employee;
import java.io.Serializable;

/**
 *
 * @author Giang
 */
public class EmployeeDTO implements Serializable {

    private Employee e;

    public EmployeeDTO() {
        e = new Employee();
    }

    public EmployeeDTO(Employee e) {
        this.e = e;
    }

    public Employee getEmployee() {
        return e;
    }

    public void setEmployee(Employee e) {
        this.e = e;
    }

    public Short getId() {
        return e.getId();
    }

    public void setId(int id) {
        e.setId(Short.parseShort(id + ""));
    }

    public String getUsername() {
        return e.getUsername();
    }

    public void setUsername(String username) {
        e.setUsername(username);
    }

    public String getInfo() {
        return e.getInfo();
    }

    public void setInfo(String info) {
        e.setInfo(info);
    }

    public boolean getIsEnabled() {
        return e.getIsEnabled();
    }

    public void setIsEnabled(boolean isEnabled) {
        e.setIsEnabled(isEnabled);
    }

    public ManagerDTO getManager() {
        return new ManagerDTO(e.getManager());
    }

    public void setManager(ManagerDTO manager) {
        e.setManager(manager.getManager());
    }
}
