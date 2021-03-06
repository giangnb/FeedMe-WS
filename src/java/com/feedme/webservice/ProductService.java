/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.ProductDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface ProductService {

    public List<ProductDTO> fetchProducts();

    public ProductDTO fetchProductById(short id);
    
    public List<ProductDTO> fetchProductByName(String name);
    
    public List<ProductDTO> fetchProductByCategory(com.feedme.entities.Category category);
    
    public List<ProductDTO> fetchProductByNameAndCategory(String name, com.feedme.entities.Category cat);

    public boolean addProduct(ProductDTO dto);

    public boolean updateProduct(ProductDTO dto);
    
    public boolean removeProduct(short id);
}
