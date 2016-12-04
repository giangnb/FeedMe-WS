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
    void addManager(ManagerDTO m);
    void updateManager(ManagerDTO m);
    void removeManager(short id);
    List<ManagerDTO> fetchManagers();
    ManagerDTO fetchManagerById(short id);
}
