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
import com.feedme.dto.CategoryDTO;
import com.feedme.dto.EmployeeDTO;
import com.feedme.dto.LogDTO;
import com.feedme.dto.ManagerDTO;
import com.feedme.dto.OrderDetailDTO;
import com.feedme.dto.OrderStatusDTO;
import com.feedme.entities.Manager;
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
        ProductService, PromotedService, PropertyService, AccountService{
    
    // <editor-fold defaultstate="collapsed" desc="Categories Management"> 
    @WebMethod(operationName = "addCategory")
    @Override
    public void addCategory(@WebParam(name = "category") CategoryDTO c) {
        new CategoryDAO().add(c);
    }

    @WebMethod(operationName = "updateCategory")
    @Override
    public void updateCategory(@WebParam(name = "category") CategoryDTO c) {
        new CategoryDAO().update(c);
    }

    @WebMethod(operationName = "removeCategory")
    @Override
    public void removeCategory(@WebParam(name = "categoryId") short id) {
        new CategoryDAO().remove(id);
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
    public void addEmployee(@WebParam(name = "employee") EmployeeDTO e) {
        new EmployeeDAO().add(e);
    }

    @WebMethod(operationName = "updateEmployee")
    @Override
    public void updateEmployee(@WebParam(name = "employee") EmployeeDTO e) {
        new EmployeeDAO().update(e);
    }

    @WebMethod(operationName = "removeEmployee")
    @Override
    public void removeEmployee(@WebParam(name = "employeeId") short id) {
        new EmployeeDAO().remove(id);
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
    public void addLog(@WebParam(name="log") LogDTO log) {
        new LogDAO().add(log);
    }

    @WebMethod(operationName = "updateLog")
    @Override
    public void updateLog(@WebParam(name="log") LogDTO log) {
        new LogDAO().update(log);
    }

    @WebMethod(operationName = "removeLog")
    @Override
    public void removeLog(@WebParam(name="logId") int id) {
        new LogDAO().remove(id);
    }

    @WebMethod(operationName = "fetchLogs")
    @Override
    public List<LogDTO> fetchLogs(@WebParam(name="fromTime") long from, @WebParam(name="toTime") long to) {
        return new LogDAO().getAll(from, to);
    }

    @WebMethod(operationName = "fetchLogsByEmployee")
    @Override
    public List<LogDTO> fetchLogsByEmployee(@WebParam(name="employeeId") short id) {
        return new LogDAO().getByEmployee(id);
    }

    @WebMethod(operationName = "fetchLogById")
    @Override
    public LogDTO fetchLogById(@WebParam(name="logId") int id) {
        return new LogDAO().getById(id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Managers Management"> 
    @WebMethod(operationName = "addManager")
    @Override
    public void addManager(@WebParam(name = "manager") ManagerDTO m) {
        new ManagerDAO().add(m);
    }

    @WebMethod(operationName = "updateManager")
    @Override
    public void updateManager(@WebParam(name = "manager") ManagerDTO m) {
        new ManagerDAO().update(m);
    }

    @WebMethod(operationName = "removeManager")
    @Override
    public void removeManager(@WebParam(name = "managerId") short id) {
        new ManagerDAO().remove(id);
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
    public void addOrder(@WebParam(name = "order") OrderDetailDTO o) {
        new OrderDetailDAO().add(o);
    }

    @WebMethod(operationName = "updateOrder")
    @Override
    public void updateOrder(@WebParam(name = "order") OrderDetailDTO o) {
        new OrderDetailDAO().update(o);
    }

    @WebMethod(operationName = "removeOrder")
    @Override
    public void removeOrder(@WebParam(name = "orderId") int id) {
        new OrderDetailDAO().remove(id);
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
    public void addOrderStatus(@WebParam(name = "orderStatus") OrderStatusDTO dto) {
       new OrderStatusDAO().addOrderStatus(dto);
    }

    @WebMethod(operationName = "fetchOrderStatus")
    @Override
    public List<OrderStatusDTO> fetchOrderStatus() {
        return new OrderStatusDAO().fetchOrderStatus();
    }

    @WebMethod(operationName = "fetchOrderStatusById")
    @Override
    public OrderStatusDTO fetchOrderStatusById(@WebParam(name = "orderStatusId") short id) {
        return new OrderStatusDAO().fetchOrderStatusById(id);
    }

    @WebMethod(operationName = "updateOrderStatus")
    @Override
    public boolean updateOrderStatus(@WebParam(name = "orderStatus") OrderStatusDTO dto) {
        return new OrderStatusDAO().updateOrderStatus(dto);
    }

    @WebMethod(operationName = "")
    @Override
    public boolean removeOrderStatus(@WebParam(name = "orderStatusId") short id) {
        return new OrderStatusDAO().removeOrderStatus(id);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Priviledge Management">
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Product Management">
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Promoted Management">
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Management">
    // </editor-fold>
}
