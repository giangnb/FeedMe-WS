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
    
    public PropertyDTO fetchPropertyByKey(String key) {
        Property p = em.find(Property.class, key);
        if (p == null) {
            return null;
        }
        return new PropertyDTO(p);
    }
    
    public boolean addProperty(PropertyDTO dto) {
        trans.begin();
        em.persist(dto.getProperty());
        trans.commit();
        return true;
    }
    
    public boolean updateProperty(PropertyDTO dto) {
        Property p = em.find(Property.class, dto.getKey());
        if (p == null) {
            return false;
        }
        try {
            trans.begin();
            updateProp(p, dto);
            trans.commit();
            return true;
        } catch (Exception e) {
            trans.rollback();
            return false;
        }
    }
    
    public boolean removeProperty(String key) {
        Property p = em.find(Property.class, key);
        if (p == null) {
            return false;
        }
        try {
            trans.begin();
            em.remove(p);
            trans.commit();
            return true;
        } catch (Exception e) {
            trans.rollback();
            return false;
        }        
    }
    
    private void updateProp(Property p, PropertyDTO dto) {
        p.setKey(dto.getKey());
        p.setValue(p.getValue());
    }
}
