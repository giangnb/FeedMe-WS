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

    public PropertyDTO fetchPropertyByKey(PropertyDTO dto);

    public void addProperty(PropertyDTO dto);

    public void updateProperty(PropertyDTO dto);

    public void removeProperty(String key);
}
