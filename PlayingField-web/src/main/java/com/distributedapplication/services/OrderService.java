/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication.services;

import com.distributedapplication.Order;

/**
 *
 * @author Aklil
 * This pojo is used to generate the WSDL file for the SOAP service
 */
public interface OrderService {
    
    void check(Order Order) throws Exception;

    Order process(final Order Order);

    Order shipping(final Order Order);
    
}
