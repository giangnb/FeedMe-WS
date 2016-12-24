/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giang
 */
@Entity
@Table(name = "t_promoted")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promoted.findAll", query = "SELECT p FROM Promoted p")
    , @NamedQuery(name = "Promoted.findById", query = "SELECT p FROM Promoted p WHERE p.id = :id")
    , @NamedQuery(name = "Promoted.findByTimestamp", query = "SELECT p FROM Promoted p WHERE :timestamp BETWEEN p.fromTime AND p.toTime")
    , @NamedQuery(name = "Promoted.findByFromTime", query = "SELECT p FROM Promoted p WHERE p.fromTime = :fromTime")
    , @NamedQuery(name = "Promoted.findByToTime", query = "SELECT p FROM Promoted p WHERE p.toTime = :toTime")})
public class Promoted implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "from_time")
    private String fromTime;
    @Basic(optional = false)
    @Column(name = "to_time")
    private String toTime;
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product product;

    public Promoted() {
    }

    public Promoted(Integer id) {
        this.id = id;
    }

    public Promoted(Integer id, String fromTime, String toTime) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(object instanceof Promoted)) {
            return false;
        }
        Promoted other = (Promoted) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.feedme.entities.Promoted[ id=" + id + " ]";
    }
    
}
