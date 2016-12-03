/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.CategoryDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Giang
 */
public class CategoryDAO {
    private EntityManager em;
    private EntityTransaction trans;

    public CategoryDAO() {
        em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
        trans = em.getTransaction();
    }
    
    public void addCategory(CategoryDTO c) {
        trans.begin();
        em.persist(c.getCategory());
        trans.commit();
    }
}
