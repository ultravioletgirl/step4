package es.unileon.springapp.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.service.SimpleClientManager;
import es.unileon.springapp.service.SimpleInvestmentFundManager;

public class BuyInvestmentFundControllerTest {

	 @Test
	    public void testHandleRequestView() throws Exception{		
	        BuyInvestmentFundController controller = new BuyInvestmentFundController();
	        controller.setClientManager(new SimpleInvestmentFundManager());

	        ModelAndView modelAndView = controller.handleRequest(null, null);		
	        assertEquals("buyInvestmentFund", modelAndView.getViewName());
	        assertNotNull(modelAndView.getModel());
	       
	        @SuppressWarnings("unchecked")
	        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
	        String nowValue = (String) modelMap.get("now");        
	        assertNotNull(nowValue);
	    }

}
