/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dto;

import com.feedme.entities.Priviledge;
import java.io.Serializable;

/**
 *
 * @author havietduc
 */
public class PriviledgeDTO implements Serializable{
    private Priviledge priv;
    
    public PriviledgeDTO() {
        priv = new Priviledge();
    }
    
    public PriviledgeDTO(Priviledge priv) {
        this.priv = priv;
    }
    public Priviledge getPriviledge() {
        return priv;
    }
    public Short getId() {
        return priv.getId();
    }

    public void setId(Short id) {
        this.priv.setId(Short.parseShort(id+""));
    }

    public String getName() {
        return priv.getName();
    }

    public void setName(String name) {
        this.priv.setName(name);
    }

    public String getDescription() {
        return priv.getDescription();
    }

    public void setDescription(String description) {
        this.priv.setDescription(description); 
    }

    public boolean getView() {
        return priv.getView();
    }

    public void setView(boolean view) {
        this.priv.setView(view);
    }

    public boolean getHr() {
        return priv.getHr();
    }

    public void setHr(boolean hr) {
        this.priv.setHr(hr);
    }

    public boolean getEditor() {
        return priv.getEditor();
    }

    public void setEditor(boolean editor) {
        this.priv.setEditor(editor);
    }

    public boolean getManager() {
        return priv.getManager();
    }

    public void setManager(boolean manager) {
        this.priv.setManager(manager);
    }

    public boolean getAdmin() {
        return priv.getAdmin();
    }

    public void setAdmin(boolean admin) {
        this.priv.setAdmin(admin);
    }
}
