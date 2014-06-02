/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication;

import javax.ejb.Local;

/**
 *
 * @author Aklil
 */
@Local
public interface OrderFacadeLocal {

    void check(Order Order) throws Exception;

    Order process(final Order Order);

    Order shipping(final Order Order);
    
}
