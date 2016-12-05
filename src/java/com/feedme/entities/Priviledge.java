/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.entities;

import com.feedme.dto.PriviledgeDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Giang
 */
@Entity
@Table(name = "t_priviledge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Priviledge.findAll", query = "SELECT p FROM Priviledge p")
    , @NamedQuery(name = "Priviledge.findById", query = "SELECT p FROM Priviledge p WHERE p.id = :id")
    , @NamedQuery(name = "Priviledge.findByName", query = "SELECT p FROM Priviledge p WHERE p.name = :name")
    , @NamedQuery(name = "Priviledge.findByDescription", query = "SELECT p FROM Priviledge p WHERE p.description = :description")
    , @NamedQuery(name = "Priviledge.findByView", query = "SELECT p FROM Priviledge p WHERE p.view = :view")
    , @NamedQuery(name = "Priviledge.findByHr", query = "SELECT p FROM Priviledge p WHERE p.hr = :hr")
    , @NamedQuery(name = "Priviledge.findByEditor", query = "SELECT p FROM Priviledge p WHERE p.editor = :editor")
    , @NamedQuery(name = "Priviledge.findByManager", query = "SELECT p FROM Priviledge p WHERE p.manager = :manager")
    , @NamedQuery(name = "Priviledge.findByAdmin", query = "SELECT p FROM Priviledge p WHERE p.admin = :admin")})
public class Priviledge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "_description")
    private String description;
    @Basic(optional = false)
    @Column(name = "view")
    private boolean view;
    @Basic(optional = false)
    @Column(name = "hr")
    private boolean hr;
    @Basic(optional = false)
    @Column(name = "editor")
    private boolean editor;
    @Basic(optional = false)
    @Column(name = "manager")
    private boolean manager;
    @Basic(optional = false)
    @Column(name = "admin")
    private boolean admin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priviledge")
    private List<Manager> managerList;

    public Priviledge() {
    }

    public Priviledge(Short id) {
        this.id = id;
    }
    
    private PriviledgeDTO dto;
    private Priviledge (PriviledgeDTO dto) {
         this.dto = dto;
    }

    public Priviledge(Short id, String name, String description, boolean view, boolean hr, boolean editor, boolean manager, boolean admin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.view = view;
        this.hr = hr;
        this.editor = editor;
        this.manager = manager;
        this.admin = admin;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean getHr() {
        return hr;
    }

    public void setHr(boolean hr) {
        this.hr = hr;
    }

    public boolean getEditor() {
        return editor;
    }

    public void setEditor(boolean editor) {
        this.editor = editor;
    }

    public boolean getManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @XmlTransient
    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Priviledge)) {
            return false;
        }
        Priviledge other = (Priviledge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.feedme.entities.Priviledge[ id=" + id + " ]";
    }
    
}
