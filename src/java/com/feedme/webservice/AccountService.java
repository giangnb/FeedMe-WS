/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.EmployeeDTO;
import com.feedme.dto.ManagerDTO;

/**
 *
 * @author Giang
 */
public interface AccountService {
    ManagerDTO loginManager(String user, String pass);
    EmployeeDTO loginEmployee(ManagerDTO m, String user);
    
    void updateManagerPassword(ManagerDTO m);
}
