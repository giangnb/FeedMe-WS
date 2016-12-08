/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

//import com.feedme.dto.OrderStatusDTO;
import com.feedme.entities.OrderStatus;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface OrderStatusService {

    public boolean addOrderStatus(OrderStatus os);

    public List<OrderStatus> fetchOrderStatus();

    public OrderStatus fetchOrderStatusById(short id);

    public boolean updateOrderStatus(OrderStatus os);

    public boolean removeOrderStatus(short id);
}
