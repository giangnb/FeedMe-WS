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
@Table(name = "t_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l")
    , @NamedQuery(name = "Log.findById", query = "SELECT l FROM Log l WHERE l.id = :id")
    , @NamedQuery(name = "Log.findByTime", query = "SELECT l FROM Log l WHERE l.timestamp BETWEEN :form AND :to")
    , @NamedQuery(name = "Log.findByEmployee", query = "SELECT l FROM Log l WHERE l.employee = :employee")
    , @NamedQuery(name = "Log.findByTitle", query = "SELECT l FROM Log l WHERE l.title = :title")
    , @NamedQuery(name = "Log.findByRatingAvg", query = "SELECT l FROM Log l WHERE l.ratingAvg = :ratingAvg")
    , @NamedQuery(name = "Log.findByTotalOrders", query = "SELECT l FROM Log l WHERE l.totalOrders = :totalOrders")
    , @NamedQuery(name = "Log.findByTtoalIncome", query = "SELECT l FROM Log l WHERE l.ttoalIncome = :ttoalIncome")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "rating_avg")
    private float ratingAvg;
    @Basic(optional = false)
    @Column(name = "total_orders")
    private int totalOrders;
    @Basic(optional = false)
    @Column(name = "ttoal_income")
    private double ttoalIncome;
    @Basic(optional = false)
    @Column(name = "_timestamp")
    private String timestamp;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employee;

    public Log() {
    }

    public Log(Integer id) {
        this.id = id;
    }

    public Log(Integer id, String title, float ratingAvg, int totalOrders, double ttoalIncome) {
        this.id = id;
        this.title = title;
        this.ratingAvg = ratingAvg;
        this.totalOrders = totalOrders;
        this.ttoalIncome = ttoalIncome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(float ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public double getTtoalIncome() {
        return ttoalIncome;
    }

    public void setTtoalIncome(double ttoalIncome) {
        this.ttoalIncome = ttoalIncome;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.feedme.entities.Log[ id=" + id + " ]";
    }
    
}
