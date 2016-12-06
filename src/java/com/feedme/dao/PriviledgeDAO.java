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
 * TEST: OK
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
        for (Priviledge priv : listEntity) {
            list.add(new PriviledgeDTO(priv));
        }
        return list;
    }

    public PriviledgeDTO fetchPriviledgeById(short id) {
        Priviledge find = em.find(Priviledge.class, id);
        if (find == null) {
            return null;
        }
        return new PriviledgeDTO(find);
    }

    public void addPriviledge(PriviledgeDTO dto) {
        em.getTransaction().begin();
        em.persist(dto.getPriviledge());
        em.getTransaction().commit();
    }

    public void updatePriviledge(PriviledgeDTO dto) {
        Priviledge p = em.find(Priviledge.class, dto.getId());
        if (p == null) {
            return;
        }
        em.getTransaction().begin();
        updatePriv(p, dto);
        
    }

    public void removePriviledge(short id) {

        Priviledge priv = em.find(Priviledge.class, id);
        if (priv == null) {
            return;
        }
        em.getTransaction().begin();
        em.remove(priv);
        em.getTransaction().commit();
    }

    private void updatePriv(Priviledge p, PriviledgeDTO dto) {
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setView(dto.getView());
        p.setHr(dto.getHr());
        p.setEditor(dto.getEditor());
        p.setManager(dto.getManager());
        p.setAdmin(dto.getAdmin());
    }
}
