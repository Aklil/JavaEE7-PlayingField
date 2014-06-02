/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributedapplication.springcontrollers;

//import com.distributedapplication.TestSingletonFacadeLocal;
//import com.distributedapplication.TestStatefulFacadeLocal;
//import com.distributedapplication.TestStatelessFacadeLocal;
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;
import com.distributedapplication.TestSingletonFacadeLocal;
import com.distributedapplication.TestStatefulFacadeLocal;
import com.distributedapplication.TestStatelessFacadeLocal;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
//@EJB(name ="statefulbean" , beanInterface=TestStatefulFacadeLocal.class,mappedName = "java:module/TestStatefulFacade!com.distributedapplication.TestStatefulFacadeLocal")
 @Scope("request") //creates new controller for each request so session is not persisted

public class TestController implements Serializable {
    
//    @EJB(lookup="java:global/PlayingField/TestSLSB !com.distributedapplication.springcontrollers.TestSLSBLocal")
//    @Autowired 
//    TestSLSBLocal testSLSBLocal;
//    @EJB(lookup="java:global/PlayingField/TestFacade!com.distributedapplication.springcontrollers.TestFacadeLocal")
//    private TestFacadeLocal testFacadeLocal;
    /**
     * Simply select the home view to be rendered by returning its name
     * @param response
     * @return 
     * @throws org.json.JSONException
     *  @RequestMapping annotation specifies that the home() method will handle a GET request with the URL / (default page of the application)
     */
    
//    @EJB(lookup="java:global/TestEJBFacade!com.distributedapplication.TestStatelessFacadeLocal")
//    private TestStatelessFacadeLocal testEJBFacadeLocal;
//    @Autowired 
    @EJB(mappedName = "java:module/TestStatelessFacade!com.distributedapplication.TestStatelessFacadeLocal")
    private TestStatelessFacadeLocal testStatelessFacadeLocal;
   
   
//    @Autowired
    @EJB(mappedName = "java:module/TestStatefulFacade!com.distributedapplication.TestStatefulFacadeLocal")
    private TestStatefulFacadeLocal testStatefulFacadeLocal;
    
//    @Autowired
    @EJB(mappedName = "java:module/TestSingletonFacade!com.distributedapplication.TestSingletonFacadeLocal")
    private TestSingletonFacadeLocal testSingletonFacadeLocal;
//    
////    @Autowired  
////    private TestTimerServiceFacadeLocal testTimerServiceFacadeLocal;
//            
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
        
         
         model.addAttribute("CustomerName",testStatelessFacadeLocal.getCustomerName(20000));
         return "customer";
     }
     
    @RequestMapping(value="/stateful", method = RequestMethod.GET)
     public String statefulTest(Model model){
         
         model.addAttribute("SessionCounter",testStatefulFacadeLocal.checkSessionCounter());
         return "stateful";
     }
     @RequestMapping(value="/singleton", method = RequestMethod.GET)
     public String singletonTest(Model model){
         
         model.addAttribute("CustomerName",testSingletonFacadeLocal.getCustomerName());
         return "singleton";
     }
     
     @RequestMapping(value="/index.html", method = RequestMethod.GET)
     public String testRest(){
         return "index.html";
     }
     
     @RequestMapping(value="/msg.json",method=RequestMethod.GET)
     @ResponseBody 
     public  TestSingletonFacadeLocal messageTest(final HttpServletResponse response) throws JSONException{

        JSONObject jsonRequestData = new JSONObject();	
        jsonRequestData.put("message", "Aklil");
        
       
//        Map<String, String> map = new HashMap<>();
//        
//        map.put("name",testSingletonFacadeLocal.getCustomerName());
        testSingletonFacadeLocal.setCustomerName("Aklil");
        
        return testSingletonFacadeLocal ;
//         return testSingletonFacadeLocal.getCustomerName();
     }
}
