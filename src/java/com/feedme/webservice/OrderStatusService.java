/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dto.OrderStatusDTO;
import java.util.List;

/**
 *
 * @author Giang
 */
public interface OrderStatusService {
    public void addOrderStatus(OrderStatusDTO dto);   
     public List<OrderStatusDTO> fetchOrderStatus();
     public boolean updateOrderStatus (OrderStatusDTO dto);
     public boolean removeOrderStatus(short id);
}
