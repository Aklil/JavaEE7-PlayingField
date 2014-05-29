/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication;

import javax.ejb.Singleton;

/**
 *
 * @author Aklil
 */
@Singleton
public class TestSingletonFacade implements TestSingletonFacadeLocal {
    
    String name;
    @Override
    public String getCustomerName() {
        return this.name;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void setCustomerName(String name) {
        this.name = name;
    }
}
