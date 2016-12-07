package com.feedme.dao;

import com.feedme.dto.OrderStatusDTO;
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

    public boolean addOrderStatus(OrderStatusDTO dto) {
        trans.begin();
        em.persist(dto.getOrderStatus());
        trans.commit();
        return true;
    }

    public List<OrderStatusDTO> fetchOrderStatus() {
        List<OrderStatusDTO> list = new ArrayList();
        List<OrderStatus> listEntity = em.createNamedQuery("OrderStatus.findAll").getResultList();
        listEntity.stream().map((item) -> new OrderStatusDTO(item)).forEach((dto) -> {
            list.add(dto);
        });

        return list;
    }

    public OrderStatusDTO fetchOrderStatusById(short id) {
        OrderStatus find = em.find(OrderStatus.class, id);
        if (find == null) {
            return null;
        }
        return new OrderStatusDTO(find);
    }

    public boolean updateOrderStatus(OrderStatusDTO dto) {
        OrderStatus os = em.find(OrderStatus.class, dto.getId());
        if (os == null) {
            return false;
        }
        em.getTransaction().begin();
        os.setIsStopped(dto.getIsStopped());
        os.setName(dto.getName());
        em.getTransaction().commit();
        return true;
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
