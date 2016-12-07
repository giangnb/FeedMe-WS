/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.CategoryDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface CategoryService {
    public boolean addCategory(CategoryDTO c);
    public boolean updateCategory(CategoryDTO c);
    public boolean removeCategory(short id);
    public List<CategoryDTO> fetchCategories();
    public CategoryDTO fetchCategoryById(short id);
}
