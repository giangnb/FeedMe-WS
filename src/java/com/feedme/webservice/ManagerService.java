/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.ManagerDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface ManagerService {
    boolean addManager(ManagerDTO m);
    boolean updateManager(ManagerDTO m);
    boolean removeManager(short id);
    List<ManagerDTO> fetchManagers();
    ManagerDTO fetchManagerById(short id);
}
