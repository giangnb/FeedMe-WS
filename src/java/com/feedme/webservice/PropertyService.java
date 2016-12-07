/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.PropertyDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface PropertyService {

    public List<PropertyDTO> fetchProperties();

    public PropertyDTO fetchPropertyByKey(String key);

    public boolean addProperty(PropertyDTO dto);

    public boolean updateProperty(PropertyDTO dto);

    public boolean removeProperty(String key);
}
