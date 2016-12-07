/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.EmployeeDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface EmployeeService {
    boolean addEmployee(EmployeeDTO e);
    boolean updateEmployee(EmployeeDTO e);
    boolean removeEmployee(short id);
    List<EmployeeDTO> fetchEmployees();
    List<EmployeeDTO> fetchEmployeesByManager(short id);
    EmployeeDTO fetchEmployeeById(short id);
    EmployeeDTO fetchEmployeeByUsername(String username);
}
