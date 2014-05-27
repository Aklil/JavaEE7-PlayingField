/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication;

import javax.ejb.Stateful;

/**
 *
 * @author Aklil
 */
@Stateful
public class TestStatefulFacade implements TestStatefulFacadeLocal {

    @Override
    public String getCustomerName() {
        return "Stateful Aklil";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
