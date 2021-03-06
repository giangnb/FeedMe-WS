/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.OrderDetailDTO;
import com.feedme.entities.OrderDetail;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface OrderService {
    boolean addOrder(OrderDetailDTO o);
    boolean updateOrder(OrderDetailDTO o);
    boolean removeOrder(int id);
    List<OrderDetail> fetchOrders(String from, String to);
    List<OrderDetail> fetchOrdersByEmployee(String from, String to, short id);
    OrderDetailDTO fetchOrderById(int id);
}
