/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication;

import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Aklil
 */
@Stateless
public class OrderFacade implements OrderFacadeLocal {

    @Override
    public void check(Order order) throws Exception {
        if (order.getItemNumber() == 0) {
            throw new Exception("Quantity cannot be 0!!");
        }
    }

    @Override
    public Order process(Order order) {
        order.setInvoice(order.getItemNumber() * 1.3);
        return order;
    }

    @Override
    public Order shipping(Order order) {
        order.setShippingDate(new Date());
        return order;
    }
     
}
