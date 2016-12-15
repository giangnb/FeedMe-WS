/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.ProductDTO;
import com.feedme.entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author havietduc
 */
public class ProductDAO {

    private final EntityManager em;
    private final EntityTransaction trans;

    public ProductDAO() {
        em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
        trans = em.getTransaction();
    }

    public List<ProductDTO> fetchProducts() {
        List<ProductDTO> list = new ArrayList();
        List<Product> entityList = em.createNamedQuery("Product.findAll").getResultList();
        entityList.forEach((product) -> {
            list.add(new ProductDTO(product));
        });
        return list;
    }

    public ProductDTO fetchProductById(short id) {
        Product p = em.find(Product.class, id);
        if (p == null) {
            return null;
        }
        return new ProductDTO(p);
    }

    public List<ProductDTO> fetchProductByName(String name) {
        return em.createNamedQuery("Product.findByName").setParameter("name", name).getResultList();
    }

    public boolean addProduct(ProductDTO dto) {
        trans.begin();
        em.persist(dto.getProduct());
        trans.commit();
        return true;
    }

    public boolean updateProduct(ProductDTO dto) {
        Product prd = em.find(Product.class, dto.getId());
        if (prd == null) {
            return false;
        }
        trans.begin();
        try {
            updateProd(prd, dto);
            trans.commit();
            return true;
        } catch (Exception e) {
            trans.rollback();
            return false;
        }
    }

    public boolean removeProduct(short id) {
        Product p = em.find(Product.class, id);
        if (p == null) {
            return false;
        }
        trans.begin();
        em.remove(p);
        trans.commit();
        return true;
    }

    private void updateProd(Product prd, ProductDTO dto) {
        prd.setId(dto.getId());
        prd.setName(dto.getName());
        prd.setDescription(dto.getDescription());
        prd.setPromotion(dto.getPromotion());
        prd.setPrice(dto.getPrice());
        prd.setInfo(dto.getInfo());
        prd.setIsActive(dto.getIsActive());
        prd.setCategory(dto.getCategory().getCategory());
    }
}
