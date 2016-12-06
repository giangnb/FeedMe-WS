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
    
    public List<PromotedDTO> fetchPromoteds() {
        List<PromotedDTO> list = new ArrayList<>();
        List<Promoted> entityList = em.createNamedQuery("Promoted.findAll").getResultList();
        entityList.forEach((promoted) -> {
           list.add(new PromotedDTO(promoted));
        });
        return list;
    }
    
    public PromotedDTO fetchPromotedById(int id) {
         Promoted p = em.find(Promoted.class, id);
         if (p==null) {
            return null;
         }
         return new PromotedDTO(p);
    }
    
    public void addPromoted(PromotedDTO dto) {
       trans.begin();
       em.persist(dto.getPromoted());
       trans.commit();
       
    }
    
    public void updatePromoted(PromotedDTO dto) {
        Promoted p = em.find(Promoted.class, dto.getId());
        if (p == null) {
          return;
        } 
        try {
            trans.begin();
            updatePromt(p,dto);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } 
    }  
   
    public void removePromoted(int id) {
         Promoted p = em.find(Promoted.class, id);
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
    
    private void updatePromt(Promoted p, PromotedDTO dto) {
           p.setId(dto.getId());
           p.setFromTime(dto.getFromTime());
           p.setToTime(dto.getToTime());
           p.setProduct(dto.getProduct());
     }
}
