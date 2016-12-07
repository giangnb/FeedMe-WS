/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.PromotedDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface PromotedService {

    public List<PromotedDTO> fetchPromoteds();

    public PromotedDTO fetchPromotedById(int id);

    public boolean addPromoted(PromotedDTO dto);

    public boolean updatePromoted(PromotedDTO dto);

    public boolean removePromoted(int id);
}
