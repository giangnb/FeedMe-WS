/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.PriviledgeDTO;
import com.feedme.entities.Priviledge;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author havietduc
 */
public class PriviledgeDAO {
    private EntityManager em;
    private EntityTransaction trans;
    private final String PU = "FeedMe-WSPU";

    public PriviledgeDAO() {
        em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        trans = em.getTransaction();
    }
    
    public List<PriviledgeDTO> fetchPriviledges() {
          List<PriviledgeDTO> list = new ArrayList();
          List<Priviledge> listEntity = em.createNamedQuery("Priviledge.findAll").getResultList();
          for (Priviledge priv:listEntity) {
             list.add(new PriviledgeDTO(priv));
          }
          return list;
    } 
    
    public void addPriviledge(PriviledgeDTO dto) {
       em.getTransaction().begin();
       em.persist(dto.getPriviledge());
       em.getTransaction().commit();
    }
    
    public boolean updatePriviledge(PriviledgeDTO dto) {
       try{
            Priviledge priv = em.find(Priviledge.class, dto.getId());
            if (priv==null){
              return false;
            }
            em.getTransaction().begin();
            dto = new PriviledgeDTO(priv);
            em.getTransaction().commit();
            return true;
       }
       catch(Exception ex){
            return false;   
       }
    }
    
    
    private boolean removePriviledge(int id) {
       try{
           Priviledge priv = em.find(Priviledge.class, id);
           em.getTransaction().begin();
           em.remove(priv);
           em.getTransaction().commit();
       return true;
       }
       catch(Exception e){
          return false;
       }
    }
}
