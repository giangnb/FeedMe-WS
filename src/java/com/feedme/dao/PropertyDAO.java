/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.PropertyDTO;
import com.feedme.entities.Property;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Sentinel
 */
public class PropertyDAO {
    
    private EntityManager em;
    private EntityTransaction trans;
    
    public PropertyDAO() {
        em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
        trans = em.getTransaction();
    }
    
    public List<PropertyDTO> fetchProperties() {
        List<PropertyDTO> list = new ArrayList<>();
        List<Property> entities = em.createNamedQuery("Property.findAll").getResultList();
        entities.forEach((property) -> {
            list.add(new PropertyDTO(property));
        });
        return list;
    }
    
    public PropertyDTO fetchPropertyByKey(PropertyDTO dto) {
        Property p = em.find(Property.class, dto.getKey());
        if (p == null) {
            return null;
        }
        return new PropertyDTO(p);
    }
    
    public void addProperty(PropertyDTO dto) {
        trans.begin();
        em.persist(dto.getProperty());
        trans.commit();
    }
    
    public void updateProperty(PropertyDTO dto) {
        Property p = em.find(Property.class, dto.getKey());
        if (p == null) {
            return;
        }
        try {
            trans.begin();
            updateProp(p, dto);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        }
    }
    
    public void removeProperty(String key) {
        Property p = em.find(Property.class, key);
        if (p == null) {
            return;
        }
        try {
            trans.begin();
            em.remove(p);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        }        
    }
    
    private void updateProp(Property p, PropertyDTO dto) {
        p.setKey(dto.getKey());
        p.setValue(p.getValue());
    }
    public static void main(String[] args) {
        System.out.println(new PropertyDAO().fetchProperties());
    }
}
