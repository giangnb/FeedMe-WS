/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.CategoryDTO;
import com.feedme.entities.Category;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<CategoryDTO> getAll() {
        List<CategoryDTO> list = new ArrayList<>();
        List<Category> resultList = em.createNamedQuery("Category.findAll").getResultList();
        for (Category c : resultList) {
            list.add(new CategoryDTO(c));
        }
        return list;
    }
    
    public CategoryDTO getById(Short id) {
        Category c = em.find(Category.class, id);
        if (c==null) {
            return null;
        }
        return new CategoryDTO(c);
    }
    
    public void add(CategoryDTO c) {
        trans.begin();
        em.persist(c.getCategory());
        trans.commit();
    }
    
    public void update(CategoryDTO cat) {
        Category c = cat.getCategory();
        Category origin = em.find(Category.class, c.getId());
        if (origin==null) {
            return;
        }
        trans.begin();
        try {
            origin.setDescription(c.getDescription());
            origin.setName(c.getName());
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }
    }
    
    public void remove(Short id) {
        Category c = em.find(Category.class, id);
        if (c==null) {
            return;
        }
        trans.begin();
        em.remove(c);
        trans.commit();
    }
}
