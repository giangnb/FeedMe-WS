/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Manager;
import com.feedme.info.Information;
import com.feedme.utils.Json;
import java.io.Serializable;

/**
 *
 * @author Giang
 */
public class ManagerDTO implements Serializable{
    private Manager m;

    public ManagerDTO() {
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

    public Information getInfo() {
        try {
            return Json.DeserializeObject(m.getInfo(), Information.class);
        } catch (Exception ex) {
            return new Information();
        }
    }

    public void setInfo(Information info) {
        try {
            m.setInfo(Json.SerializeObject(info));
        } catch (Exception ex) {
        }
    }

    public PriviledgeDTO getPriviledge() {
        return new PriviledgeDTO(m.getPriviledge());
    }

    public void setPriviledge(PriviledgeDTO priviledge) {
        m.setPriviledge(priviledge.getPriviledge());
    }
}
