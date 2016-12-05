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
import javax.persistence.Persistence;

/**
 *
 * @author havietduc
 */
public class ProductDAO {
      public List<ProductDTO> fetchProducts() {
          EntityManager em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
         List<ProductDTO> list = new ArrayList();
         List<Product> entityList = em.createNamedQuery("Product.findAll").getResultList();
         entityList.forEach((product) -> {
             list.add(new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getPromotion(), product.getInfo(),product.getIsActive(),product.getCategory()));
          });
         return list;
      }
}
