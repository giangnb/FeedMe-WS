/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Manager;
import java.io.Serializable;

/**
 *
 * @author Giang
 */
public class ManagerDTO implements Serializable{
    private Manager m;

    public ManagerDTO() {
        m = new Manager();
    }

    public ManagerDTO(Manager m) {
        this.m = m;
    }

    public Manager getManager() {
        return m;
    }

    public void setManager(Manager m) {
        this.m = m;
    }
    
    public Short getId() {
        return m.getId();
    }

    public void setId(int id) {
        m.setId(Short.parseShort(id+""));
    }

    public String getUsername() {
        return m.getUsername();
    }

    public void setUsername(String username) {
        m.setUsername(username);
    }

    public String getPassword() {
        return m.getPassword();
    }

    public void setPassword(String password) {
        m.setPassword(password);
    }

    public String getInfo() {
       return m.getInfo();
    }

    public void setInfo(String info) {
        m.setInfo(info);
    }

    public PriviledgeDTO getPriviledge() {
        return new PriviledgeDTO(m.getPriviledge());
    }

    public void setPriviledge(PriviledgeDTO priviledge) {
        m.setPriviledge(priviledge.getPriviledge());
    }
}
