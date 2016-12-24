/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.PromotedDTO;
import com.feedme.entities.Promoted;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Sentinel
 */
public class PromotedDAO {
    private  EntityManager em;
    private  EntityTransaction trans;

    public PromotedDAO() {
        em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
        trans = em.getTransaction();
    }
    
    public List<Promoted> fetchPromoteds() {
        return em.createNamedQuery("Promoted.findAll").getResultList();
    }
    
    public List<Promoted> fetchPromotedByTimestamp(String timestamp) {
        return em.createNamedQuery("Promoted.findByTimestamp")
                .setParameter("timestamp", timestamp).getResultList();
    }
    
    public PromotedDTO fetchPromotedById(int id) {
         Promoted p = em.find(Promoted.class, id);
         if (p==null) {
            return null;
         }
         return new PromotedDTO(p);
    }
    
    public boolean addPromoted(PromotedDTO dto) {
       trans.begin();
       em.persist(dto.getPromoted());
       trans.commit();
       return true;
    }
    
    public boolean updatePromoted(PromotedDTO dto) {
        Promoted p = em.find(Promoted.class, dto.getId());
        if (p == null) {
          return false;
        } 
        try {
            trans.begin();
            updatePromt(p,dto);
            trans.commit();
            return true;
        } catch (Exception e) {
            trans.rollback();
            return false;
        } 
    }  
   
    public boolean removePromoted(int id) {
         Promoted p = em.find(Promoted.class, id);
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
    
    private void updatePromt(Promoted p, PromotedDTO dto) {
           p.setId(dto.getId());
           p.setFromTime(dto.getFromTime());
           p.setToTime(dto.getToTime());
           p.setProduct(dto.getProduct().getProduct());
     }
}
