/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.EmployeeDTO;
import com.feedme.entities.Employee;
import com.feedme.entities.Manager;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Giang
 */
public class EmployeeDAO {
    private EntityManager em;
    private EntityTransaction trans;

    public EmployeeDAO() {
        em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
        trans = em.getTransaction();
    }
    
    public void add(EmployeeDTO e) {
        trans.begin();
        em.persist(e.getEmployee());
        trans.commit();
    }
    
    public void update(EmployeeDTO emp) {
        Employee e = emp.getEmployee();
        Employee find = em.find(Employee.class, e.getId());
        if (find==null) {
            return;
        }
        trans.begin();
        try {
            find.setInfo(e.getInfo());
            find.setIsEnabled(e.getIsEnabled());
            find.setManager(e.getManager());
            find.setUsername(e.getUsername());
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
        }
    }
    
    public void remove(Short id) {
        Employee find = em.find(Employee.class, id);
        if (find==null) {
            return;
        }
        trans.begin();
        em.remove(find);
        trans.commit();
    }
    
    public List<EmployeeDTO> getAll() {
        List<EmployeeDTO> list = new ArrayList<>();
        List<Employee> resultList = em.createNamedQuery("Employee.findAll").getResultList();
        for (Employee e : resultList) {
            list.add(new EmployeeDTO(e));
        }
        return list;
    }
    
    public EmployeeDTO getById(Short id) {
        Employee find = em.find(Employee.class, id);
        if (find==null) {
            return null;
        }
        return new EmployeeDTO(find);
    }
    
    public List<EmployeeDTO> getByManager(Manager m) {
        List<EmployeeDTO> list = new ArrayList<>();
        List<Employee> resultList = em.createNamedQuery("Employee.findByManager")
                .setParameter("manager", m).getResultList();
        for (Employee e : resultList) {
            list.add(new EmployeeDTO(e));
        }
        return list;
    }
    
    public EmployeeDTO getByUsername(String username) {
        List<Employee> resultList = em.createNamedQuery("Employee.findByUsername")
                .setParameter("username", username).getResultList();
        if (resultList.size()>0) {
            return new EmployeeDTO(resultList.get(0));
        }
        return null;
    }
}
