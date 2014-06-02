/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication.services;

import com.distributedapplication.Order;
import com.distributedapplication.OrderFacadeLocal;
import com.distributedapplication.services.OrderService;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Aklil
 * This is the end point service  
 */
@WebService  //(serviceName="OrderService")   //JAX-WS
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class OrderEndPointWebService extends SpringBeanAutowiringSupport{
    
//    @EJB(mappedName = "java:module/OrderFacade!com.distributedapplication.OrderFacadeLocal")
//    private OrderFacadeLocal orderFacade;
    
    
//     private static final String HELLO = "Hello";
//
//    @WebMethod(operationName = "sayHello")
//    public String sayHelloToTheUser(@WebParam(name = "name") String userName) {
//        return HELLO + " " + userName;
//    }
    
    @Autowired
    private OrderService orderService;
    
    @WebMethod // this is given by default: needed to customize the method further
    public void check(Order order) throws Exception{
        orderService.check(order);
    }
    
    //@WebParam customizes the method parameters
    public Order process(@WebParam(name = "order") Order order){
        return orderService.process(order);
    }
    
    public Order shipping(Order order){
        return orderService.shipping(order);
    }
}
