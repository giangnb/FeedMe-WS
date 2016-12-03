/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.webservice;

import com.feedme.dao.CategoryDAO;
import com.feedme.dto.CategoryDTO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Giang
 */
@WebService(serviceName = "ApplicationSevice")
public class ApplicationSevice {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "addCategory")
    public void addCategory(@WebParam(name = "category") CategoryDTO c) {
        new CategoryDAO().addCategory(c);
    }
}
