package com.feedme.dao;

//import com.feedme.dto.OrderStatusDTO;
import com.feedme.entities.OrderStatus;
import java.util.ArrayList;
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
 * @author havietduc
 * TEST: OK
 */
public class OrderStatusDAO {

    private EntityManager em;
    private EntityTransaction trans;
    private final String PU = "FeedMe-WSPU";

    public OrderStatusDAO() {
        em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        trans = em.getTransaction();
    }

    public boolean addOrderStatus(OrderStatus status) {
        trans.begin();
        em.persist(status);
        trans.commit();
        return true;
    }

    public List<OrderStatus> fetchOrderStatus() {
        return em.createNamedQuery("OrderStatus.findAll").getResultList();
    }

    public OrderStatus fetchOrderStatusById(short id) {
        OrderStatus find = em.find(OrderStatus.class, id);
        if (find == null) {
            return null;
        }
        return find;
    }

    public boolean updateOrderStatus(OrderStatus os) {
        OrderStatus origin = em.find(OrderStatus.class, os.getId());
        if (os == null) {
            return false;
        }
        try{
        em.getTransaction().begin();
        origin.setName(os.getName());
        origin.setIsStopped(os.getIsStopped());
        em.getTransaction().commit();
        return true;
        }
        catch (Exception e) {
           em.getTransaction().rollback();
           return false;
        }
    }

    public boolean removeOrderStatus(short id) {
        OrderStatus os = em.find(OrderStatus.class, id);
        if (os == null) {
            return false;
        }
        em.getTransaction().begin();
        em.remove(os);
        em.getTransaction().commit();
        return true;
    }
}
