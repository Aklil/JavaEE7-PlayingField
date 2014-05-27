/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication.springcontrollers;

import com.distributedapplication.TestEJBFacadeLocal;
import com.distributedapplication.TestSingletonFacadeLocal;
import com.distributedapplication.TestStatefulFacadeLocal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Aklil
 */
/**
 * 
 * Handles requests
 * '@controller' shows a spring controller
 * 'handlermappingrequest' bound the 'servelet context' and the 'webapplication context'
 */
@Controller
//@Lazy(true)

//@RequestMapping("/home")
public class TestController {
    
//    @EJB(lookup="java:global/PlayingField/TestSLSB !com.distributedapplication.springcontrollers.TestSLSBLocal")
//    @Autowired 
//    TestSLSBLocal testSLSBLocal;
//    @EJB(lookup="java:global/PlayingField/TestFacade!com.distributedapplication.springcontrollers.TestFacadeLocal")
//    private TestFacadeLocal testFacadeLocal;
    /**
     * Simply select the home view to be rendered by returning its name
     *  @RequestMapping annotation specifies that the home() method will handle a GET request with the URL / (default page of the application)
     */
    
//    @EJB(lookup="java:global/TestEJBFacade!com.distributedapplication.TestEJBFacadeLocal")
//    private TestEJBFacadeLocal testEJBFacadeLocal;
    @Autowired 
    private TestEJBFacadeLocal testEJBFacadeLocal;
   
    
    @Autowired
    private TestStatefulFacadeLocal testStatefulFacadeLocal;
    
    @Autowired
    private TestSingletonFacadeLocal testSingletonFacadeLocal;
    
    @RequestMapping(value="/home", method = RequestMethod.GET) 
    public String homeTest(Locale locale, Model model){
        Date date = new Date();  
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
            DateFormat.LONG, DateFormat.LONG,locale);
         
        String formattedDate = dateFormat.format(date);
        
        //serverTime is a model attribute to passed to the view 
        // it will bounded to the view
        model.addAttribute("serverTime", formattedDate);
          
          return "home";  //name of .jsp to be invoked
    }
     @RequestMapping(value="/customer", method = RequestMethod.GET)
     public String ejbTest(Model model){
         
         model.addAttribute("CustomerName",testEJBFacadeLocal.getCustomerName());
         return "customer";
     }
     
    @RequestMapping(value="/stateful", method = RequestMethod.GET)
     public String statefulTest(Model model){
         
         model.addAttribute("CustomerName",testStatefulFacadeLocal.getCustomerName());
         return "stateful";
     }
     @RequestMapping(value="/singleton", method = RequestMethod.GET)
     public String singletonTest(Model model){
         
         model.addAttribute("CustomerName",testSingletonFacadeLocal.getCustomerName());
         return "singleton";
     }
}
