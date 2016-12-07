/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.LogDTO;
import com.feedme.entities.Employee;
import com.feedme.entities.Log;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Giang
 */
public class LogDAO {
    private EntityManager em;
    private EntityTransaction trans;

    public LogDAO() {
        em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
        trans = em.getTransaction();
    }
    
    public boolean add(LogDTO l) {
        trans.begin();
        em.persist(l.getLog());
        trans.commit();
        return true;
    }
    
    public boolean update(LogDTO log) {
        Log l = log.getLog();
        Log find = em.find(Log.class, l.getId());
        if (find==null) {
            return false;
        }
        trans.begin();
        try {
            find.setEmployee(l.getEmployee());
            find.setRatingAvg(l.getRatingAvg());
            find.setTitle(l.getTitle());
            find.setTotalOrders(l.getTotalOrders());
            find.setTtoalIncome(l.getTtoalIncome());
            trans.commit();
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return true;
        }
    }
    
    public boolean remove(int id) {
        Log find = em.find(Log.class, id);
        if (find==null) {
            return false;
        }
        trans.begin();
        em.remove(find);
        trans.commit();
        return true;
    }
    
    public List<LogDTO> getAll(long from, long to) {
        List<LogDTO> list = new ArrayList<>();
        List<Log> resultList = em.createNamedQuery("Log.findByTime")
                .setParameter("from", from+"")
                .setParameter("to", to+"").getResultList();
        for (Log l : resultList) {
            list.add(new LogDTO(l));
        }
        return list;
    }
    
    public List<LogDTO> getByEmployee(short empId) {
        List<LogDTO> list = new ArrayList<>();
        Employee emp = new EmployeeDAO().getById(empId).getEmployee();
        List<Log> resultList = em.createNamedQuery("Log.findByEmployee")
                .setParameter("employee", emp).getResultList();
        for (Log l : resultList) {
            list.add(new LogDTO(l));
        }
        return list;
    }
    
    public LogDTO getById(int id) {
        Log find = em.find(Log.class, id);
        if (find==null) {
            return null;
        }
        return new LogDTO(find);
    }
}
