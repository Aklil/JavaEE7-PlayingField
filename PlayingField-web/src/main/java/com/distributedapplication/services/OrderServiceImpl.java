/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication.services;

import com.distributedapplication.Order;
import com.distributedapplication.OrderFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author Aklil
 * used to generate WSDL for the SOAP service
 */
public class OrderServiceImpl implements OrderService{
   
    
//    @Override
//    public void check(Order order) throws Exception {
//        if (order.getItemNumber() == 0) {
//            throw new Exception("Quantity cannot be 0!!");
//        }
//    }
//
//    @Override
//    public Order process(Order order) {
//        order.setInvoice(order.getItemNumber() * 1.3);
//        return order;
//    }
//
//    @Override
//    public Order shipping(Order order) {
//        order.setShippingDate(new Date());
//        return order;
//    }
       
    
    @EJB(mappedName = "java:module/OrderFacade!com.distributedapplication.OrderFacadeLocal")
    private OrderFacadeLocal orderFacadeLocal;
    
    
    @Override
    public void check(Order Order) throws Exception {
        
        orderFacadeLocal.check(Order);
    }

    @Override
    public Order process(Order Order) {
        return orderFacadeLocal.process(Order);
    }

    @Override
    public Order shipping(Order Order) {
        return orderFacadeLocal.shipping(Order);
    }
    
}
