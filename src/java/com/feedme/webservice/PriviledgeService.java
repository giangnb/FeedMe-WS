/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.PriviledgeDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface PriviledgeService {

    public List<PriviledgeDTO> fetchPriviledges();

    public PriviledgeDTO fetchPriviledgeById(short id);

    public void addPriviledge(PriviledgeDTO dto);

    public void updatePriviledge(PriviledgeDTO dto);

    public void removePriviledge(short id);
}
