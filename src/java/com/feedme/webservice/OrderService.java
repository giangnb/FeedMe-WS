/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.OrderDetailDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface OrderService {
    void addOrder(OrderDetailDTO o);
    void updateOrder(OrderDetailDTO o);
    void removeOrder(int id);
    List<OrderDetailDTO> fetchOrders(long from, long to);
    List<OrderDetailDTO> fetchOrdersByEmployee(long from, long to, short id);
    OrderDetailDTO fetchOrderById(int id);
}
