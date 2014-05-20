package es.unileon.springapp.web;

import java.util.Map;


import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.service.SimpleInvestmentFundManager;

public class InvestmentFundInventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        InvestmentFundInventoryController controller = new InvestmentFundInventoryController();
        controller.setInvestmentFundManager(new SimpleInvestmentFundManager());

       // ModelAndView modelAndView = controller.handleRequest(null, null);		
        //assertEquals("fundsList", modelAndView.getViewName());
        //assertNotNull(modelAndView.getModel());
       
      //  @SuppressWarnings("unchecked")
      //  Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
      //  String nowValue = (String) modelMap.get("now");        
      //  assertNotNull(nowValue);
    }

}