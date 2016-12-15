/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dao.CategoryDAO;
import com.feedme.dao.EmployeeDAO;
import com.feedme.dao.LogDAO;
import com.feedme.dao.ManagerDAO;
import com.feedme.dao.OrderDetailDAO;
import com.feedme.dao.OrderStatusDAO;
import com.feedme.dao.PriviledgeDAO;
import com.feedme.dao.ProductDAO;
import com.feedme.dao.PromotedDAO;
import com.feedme.dao.PropertyDAO;
import com.feedme.dto.CategoryDTO;
import com.feedme.dto.EmployeeDTO;
import com.feedme.dto.LogDTO;
import com.feedme.dto.ManagerDTO;
import com.feedme.dto.OrderDetailDTO;
//import com.feedme.dto.OrderStatusDTO;
import com.feedme.dto.PriviledgeDTO;
import com.feedme.dto.ProductDTO;
import com.feedme.dto.PromotedDTO;
import com.feedme.dto.PropertyDTO;
import com.feedme.entities.Manager;
import com.feedme.entities.OrderStatus;
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
        ProductService, PromotedService, PropertyService, AccountService {

    // <editor-fold defaultstate="collapsed" desc="Categories Management"> 
    @WebMethod(operationName = "addCategory")
    @Override
    public boolean addCategory(@WebParam(name = "category") CategoryDTO c) {
        return new CategoryDAO().add(c);
    }

    @WebMethod(operationName = "updateCategory")
    @Override
    public boolean updateCategory(@WebParam(name = "category") CategoryDTO c) {
        return new CategoryDAO().update(c);
    }

    @WebMethod(operationName = "removeCategory")
    @Override
    public boolean removeCategory(@WebParam(name = "categoryId") short id) {
        return new CategoryDAO().remove(id);
    }

    @WebMethod(operationName = "fetchCategories")
    @Override
    public List<CategoryDTO> fetchCategories() {
        return new CategoryDAO().getAll();
    }

    @WebMethod(operationName = "fetchCategoryById")
    @Override
    public CategoryDTO fetchCategoryById(@WebParam(name = "categoryId") short id) {
        return new CategoryDAO().getById(id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Employees Management"> 
    @WebMethod(operationName = "addEmployee")
    @Override
    public boolean addEmployee(@WebParam(name = "employee") EmployeeDTO e) {
        return new EmployeeDAO().add(e);
    }

    @WebMethod(operationName = "updateEmployee")
    @Override
    public boolean updateEmployee(@WebParam(name = "employee") EmployeeDTO e) {
        return new EmployeeDAO().update(e);
    }

    @WebMethod(operationName = "removeEmployee")
    @Override
    public boolean removeEmployee(@WebParam(name = "employeeId") short id) {
        return new EmployeeDAO().remove(id);
    }

    @WebMethod(operationName = "fetchEmployees")
    @Override
    public List<EmployeeDTO> fetchEmployees() {
        return new EmployeeDAO().getAll();
    }

    @WebMethod(operationName = "fetchEmployeesByManager")
    @Override
    public List<EmployeeDTO> fetchEmployeesByManager(@WebParam(name = "managerId") short id) {
        Manager m = new ManagerDAO().getById(id).getManager();
        return new EmployeeDAO().getByManager(m);
    }

    @WebMethod(operationName = "fetchEmployeeById")
    @Override
    public EmployeeDTO fetchEmployeeById(@WebParam(name = "employeeId") short id) {
        return new EmployeeDAO().getById(id);
    }

    @WebMethod(operationName = "fetchEmployeeByUsername")
    @Override
    public EmployeeDTO fetchEmployeeByUsername(@WebParam(name = "employeeUsername") String username) {
        return new EmployeeDAO().getByUsername(username);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Employee's Logs Management"> 
    @WebMethod(operationName = "addLog")
    @Override
    public boolean addLog(@WebParam(name = "log") LogDTO log) {
        return new LogDAO().add(log);
    }

    @WebMethod(operationName = "updateLog")
    @Override
    public boolean updateLog(@WebParam(name = "log") LogDTO log) {
        return new LogDAO().update(log);
    }

    @WebMethod(operationName = "removeLog")
    @Override
    public boolean removeLog(@WebParam(name = "logId") int id) {
        return new LogDAO().remove(id);
    }

    @WebMethod(operationName = "fetchLogs")
    @Override
    public List<LogDTO> fetchLogs(@WebParam(name = "fromTime") long from, @WebParam(name = "toTime") long to) {
        return new LogDAO().getAll(from, to);
    }

    @WebMethod(operationName = "fetchLogsByEmployee")
    @Override
    public List<LogDTO> fetchLogsByEmployee(@WebParam(name = "employeeId") short id) {
        return new LogDAO().getByEmployee(id);
    }

    @WebMethod(operationName = "fetchLogById")
    @Override
    public LogDTO fetchLogById(@WebParam(name = "logId") int id) {
        return new LogDAO().getById(id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Managers Management"> 
    @WebMethod(operationName = "addManager")
    @Override
    public boolean addManager(@WebParam(name = "manager") ManagerDTO m) {
        return new ManagerDAO().add(m);
    }

    @WebMethod(operationName = "updateManager")
    @Override
    public boolean updateManager(@WebParam(name = "manager") ManagerDTO m) {
        return new ManagerDAO().update(m);
    }

    @WebMethod(operationName = "removeManager")
    @Override
    public boolean removeManager(@WebParam(name = "managerId") short id) {
        return new ManagerDAO().remove(id);
    }

    @WebMethod(operationName = "fetchManagers")
    @Override
    public List<ManagerDTO> fetchManagers() {
        return new ManagerDAO().getAll();
    }

    @WebMethod(operationName = "fetchManagerById")
    @Override
    public ManagerDTO fetchManagerById(@WebParam(name = "managerId") short id) {
        return new ManagerDAO().getById(id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Orders Detail Management"> 
    @WebMethod(operationName = "addOrder")
    @Override
    public boolean addOrder(@WebParam(name = "order") OrderDetailDTO o) {
        return new OrderDetailDAO().add(o);
    }

    @WebMethod(operationName = "updateOrder")
    @Override
    public boolean updateOrder(@WebParam(name = "order") OrderDetailDTO o) {
        return new OrderDetailDAO().update(o);
    }

    @WebMethod(operationName = "removeOrder")
    @Override
    public boolean removeOrder(@WebParam(name = "orderId") int id) {
        return new OrderDetailDAO().remove(id);
    }

    @WebMethod(operationName = "fetchOrders")
    @Override
    public List<OrderDetailDTO> fetchOrders(@WebParam(name = "fromTime") long from, @WebParam(name = "toTime") long to) {
        return new OrderDetailDAO().getAll(from, to);
    }

    @WebMethod(operationName = "fetchOrdersByEmployee")
    @Override
    public List<OrderDetailDTO> fetchOrdersByEmployee(@WebParam(name = "fromTime") long from, @WebParam(name = "toTime") long to, @WebParam(name = "employeeId") short id) {
        EmployeeDTO emp = new EmployeeDAO().getById(id);
        return new OrderDetailDAO().getByEmployee(from, to, emp);
    }

    @WebMethod(operationName = "fetchOrderById")
    @Override
    public OrderDetailDTO fetchOrderById(@WebParam(name = "orderId") int id) {
        return new OrderDetailDAO().getById(id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Accounts Management">
    @WebMethod(operationName = "loginManager")
    @Override
    public ManagerDTO loginManager(@WebParam(name = "username") String user, @WebParam(name = "password") String pass) {
        return new ManagerDAO().getLogin(user, pass);
    }

    @WebMethod(operationName = "loginEmployee")
    @Override
    public EmployeeDTO loginEmployee(@WebParam(name = "manager") ManagerDTO m, @WebParam(name = "employeeUsername") String user) {
        EmployeeDTO emp = new EmployeeDAO().getByUsername(user);
        if (emp.getManager().getId().equals(m.getId())) {
            return emp;
        }
        return null;
    }

    @WebMethod(operationName = "updateManagerPassword")
    @Override
    public void updateManagerPassword(@WebParam(name = "manager") ManagerDTO m) {
        new ManagerDAO().updatePassword(m);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Order Status Management">
    @WebMethod(operationName = "addOrderStatus")
    @Override
    public boolean addOrderStatus(@WebParam(name = "orderStatus") OrderStatus os) {
        return new OrderStatusDAO().addOrderStatus(os);
    }

    @WebMethod(operationName = "fetchOrderStatus")
    @Override
    public List<OrderStatus> fetchOrderStatus() {
        return new OrderStatusDAO().fetchOrderStatus();
    }

    @WebMethod(operationName = "fetchOrderStatusById")
    @Override
    public OrderStatus fetchOrderStatusById(@WebParam(name = "orderStatusId") short id) {
        return new OrderStatusDAO().fetchOrderStatusById(id);
    }

    @WebMethod(operationName = "updateOrderStatus")
    @Override
    public boolean updateOrderStatus(@WebParam(name = "orderStatus") OrderStatus os) {
        return new OrderStatusDAO().updateOrderStatus(os);
    }

    @WebMethod(operationName = "")
    @Override
    public boolean removeOrderStatus(@WebParam(name = "orderStatusId") short id) {
        return new OrderStatusDAO().removeOrderStatus(id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Priviledge Management">
    //@WebMethod(operationName = "")
    @Override
    @WebMethod(operationName = "fetchPriviledges")
    public List<PriviledgeDTO> fetchPriviledges() {
        return new PriviledgeDAO().fetchPriviledges();
    }

    @Override
    @WebMethod(operationName = "fetchPriviledgeById")
    public PriviledgeDTO fetchPriviledgeById(@WebParam(name = "priviledgeId") short id) {
        return new PriviledgeDAO().fetchPriviledgeById(id);
    }

    @Override
    @WebMethod(operationName = "addPriviledge")
    public boolean addPriviledge(@WebParam(name = "priviledge") PriviledgeDTO dto) {
        return new PriviledgeDAO().addPriviledge(dto);
    }

    @Override
    @WebMethod(operationName = "updatePriviledge")
    public boolean updatePriviledge(@WebParam(name = "updatePriviledge") PriviledgeDTO dto) {
        return new PriviledgeDAO().updatePriviledge(dto);
    }

    @Override
    @WebMethod(operationName = "removePriviledge")
    public boolean removePriviledge(@WebParam(name = "priviledId") short id) {
        return new PriviledgeDAO().removePriviledge(id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Product Management">
    @Override
    @WebMethod(operationName = "fetchProducts")
    public List<ProductDTO> fetchProducts() {
        return new ProductDAO().fetchProducts();
    }

    @Override
    @WebMethod(operationName = "fetchProductsById")
    public ProductDTO fetchProductById(@WebParam(name = "productId") short id) {
        return new ProductDAO().fetchProductById(id);
    }

    @Override
    @WebMethod(operationName = "fetchProductsByName")
    public java.util.List<ProductDTO> fetchProductByName(@WebParam(name = "productName") String name) {
        return new ProductDAO().fetchProductByName(name);
    }

    @Override
    @WebMethod(operationName = "addProduct")
    public boolean addProduct(@WebParam(name = "product") ProductDTO dto) {
        return new ProductDAO().addProduct(dto);
    }

    @Override
    @WebMethod(operationName = "updateProduct")
    public boolean updateProduct(@WebParam(name = "updateProduct") ProductDTO dto) {
        return new ProductDAO().updateProduct(dto);
    }

    @Override
    @WebMethod(operationName = "removeProduct")
    public boolean removeProduct(@WebParam(name = "productId") short id) {
        return new ProductDAO().removeProduct(id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Promoted Management">
    @Override
    @WebMethod(operationName = "fetchPromoteds")
    public List<PromotedDTO> fetchPromoteds() {
        return new PromotedDAO().fetchPromoteds();
    }

    @Override
    @WebMethod(operationName = "fetchPromotedById")
    public PromotedDTO fetchPromotedById(@WebParam(name = "promotedId") int id) {
        return new PromotedDAO().fetchPromotedById(id);
    }

    @Override
    @WebMethod(operationName = "addPromoted")
    public boolean addPromoted(@WebParam(name = "promoted") PromotedDTO dto) {
        return new PromotedDAO().addPromoted(dto);
    }

    @Override
    @WebMethod(operationName = "updatePromoted")
    public boolean updatePromoted(@WebParam(name = "promotedUpdate") PromotedDTO dto) {
        return new PromotedDAO().updatePromoted(dto);
    }

    @Override
    @WebMethod(operationName = "removePromoted")
    public boolean removePromoted(@WebParam(name = "promotedId") int id) {
        return new PromotedDAO().removePromoted(id);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Property Management">
    @Override
    @WebMethod(operationName = "fetchProperties")
    public List<PropertyDTO> fetchProperties() {
        return new PropertyDAO().fetchProperties();
    }

    @Override
    @WebMethod(operationName = "fetchPropertieByKey")
    public PropertyDTO fetchPropertyByKey(@WebParam(name = "key") String key) {
        return new PropertyDAO().fetchPropertyByKey(key);
    }

    @Override
    @WebMethod(operationName = "addPropertie")
    public boolean addProperty(@WebParam(name = "property") PropertyDTO dto) {
        return new PropertyDAO().addProperty(dto);
    }

    @Override
    @WebMethod(operationName = "updateProperties")
    public boolean updateProperty(@WebParam(name = "propertyUpdate") PropertyDTO dto) {
        return new PropertyDAO().updateProperty(dto);
    }

    @Override
    @WebMethod(operationName = "removeProperties")
    public boolean removeProperty(@WebParam(name = "propertyKey") String key) {
        return new PropertyDAO().removeProperty(key);
    }
    // </editor-fold>

}
