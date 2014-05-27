/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication;

import javax.ejb.Stateless;

/**
 *
 * @author Aklil
 */
@Stateless
public class TestEJBFacade implements TestEJBFacadeLocal {

    @Override
    public String getCustomerName() {
        return "Aklil";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
