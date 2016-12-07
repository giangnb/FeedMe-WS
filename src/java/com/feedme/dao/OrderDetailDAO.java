package com.feedme.dao;

import com.feedme.dto.EmployeeDTO;
import com.feedme.dto.OrderDetailDTO;
import com.feedme.entities.OrderDetail;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giang
 */
public class OrderDetailDAO {
    private EntityManager em;
    private EntityTransaction trans;

    public OrderDetailDAO() {
        em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
        trans = em.getTransaction();
    }
    
    public boolean add(OrderDetailDTO o) {
        trans.begin();
        o.setOrdertime(new Date().getTime()+"");
        em.persist(o.getOrderDetail());
        trans.commit();
        return true;
    }
    
    public boolean update(OrderDetailDTO order) {
        OrderDetail o = order.getOrderDetail();
        OrderDetail find = em.find(OrderDetail.class, o.getId());
        if (find==null) {
            return false;
        }
        trans.begin();
        try {
            find.setComment(o.getComment());
            find.setCustomer(o.getCustomer());
            find.setDiscount(o.getDiscount());
            find.setEmployee(o.getEmployee());
            find.setFoods(o.getFoods());
            find.setNote(o.getNote());
            find.setRating(o.getRating());
            find.setStatus(o.getStatus());
            find.setSubtotal(o.getSubtotal());
            trans.commit();
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return false;
        }
    }
    
    public boolean remove(int id) {
        OrderDetail find = em.find(OrderDetail.class, id);
        if (find==null) {
            return false;
        }
        trans.begin();
        em.remove(find);
        trans.commit();
        return true;
    }
    
    public List<OrderDetailDTO> getAll(long from, long to) {
        List<OrderDetailDTO> list = new ArrayList<>();
        List<OrderDetail> resultList = em.createNamedQuery("OrderDetail.findByTime")
                .setParameter("from", from+"")
                .setParameter("to", to+"").getResultList();
        for (OrderDetail o : resultList) {
            list.add(new OrderDetailDTO(o));
        }
        return list;
    }
    
    public List<OrderDetailDTO> getByEmployee(long from, long to, EmployeeDTO e) {
        List<OrderDetailDTO> list = new ArrayList<>();
        List<OrderDetail> resultList = em.createNamedQuery("OrderDetail.findByEmployee")
                .setParameter("employee", e.getEmployee())
                .setParameter("from", from+"")
                .setParameter("to", to+"").getResultList();
        for (OrderDetail o : resultList) {
            list.add(new OrderDetailDTO(o));
        }
        return list;
    }
    
    public OrderDetailDTO getById(int id) {
        OrderDetail find = em.find(OrderDetail.class, id);
        if (find==null) {
            return null;
        }
        return new OrderDetailDTO(find);
    }
}
