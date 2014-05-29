/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication;

//import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aklil
 */
@Stateless
public class TestStatelessFacade implements TestStatelessFacadeLocal {
    
//    @EJB 
//    TestTimerServiceFacadeLocal testTimerServiceFacadeLocal;
    @Override
    public String getCustomerName(long duration) {
//        testTimerServiceFacadeLocal.createTimer(duration);
        return "Aklil";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
