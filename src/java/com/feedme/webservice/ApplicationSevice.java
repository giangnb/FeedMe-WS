/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dao.CategoryDAO;
import com.feedme.dao.OrderStatusDAO;
import com.feedme.dao.ProductDAO;
import com.feedme.dto.CategoryDTO;
import com.feedme.dto.OrderStatusDTO;
import com.feedme.dto.ProductDTO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Giang
 */
@WebService(serviceName = "ApplicationSevice")
public class ApplicationSevice implements CategoryService,
        EmployeeService, LogService, ManagerService, OrderService, OrderStatusService, PriviledgeService,
        ProductService, PromotedService, PropertyService{
    
    @WebMethod(operationName = "addCategory")
    @Override
    public void addCategory(@WebParam(name = "category") CategoryDTO c) {
        new CategoryDAO().addCategory(c);
    }

    @Override
    public void addOrderStatus(OrderStatusDTO dto) {
       new OrderStatusDAO().addOrderStatus(dto);
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderStatusDTO> fetchOrderStatus() {
        return new OrderStatusDAO().fetchOrderStatus();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateOrderStatus(OrderStatusDTO dto) {
        return new OrderStatusDAO().updateOrderStatus(dto);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeOrderStatus(short id) {
        return new OrderStatusDAO().removeOrderStatus(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public List<ProductDTO> fetchProducts() {
         return new ProductDAO().fetchProducts();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
