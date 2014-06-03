package es.unileon.springapp.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.repository.InMemoryInvestmentFundsDao;
import es.unileon.springapp.service.SimpleInvestmentFundManager;



public class InvestmentFundInventoryControllerTest {

	  @Test
	    public void testHandleRequestView() throws Exception{
	    	
		    InvestmentFundInventoryController controller = new InvestmentFundInventoryController();

	        SimpleInvestmentFundManager simpleInvestmentFundManager = new SimpleInvestmentFundManager();
	        	     
	        simpleInvestmentFundManager.setInvestmentFundDao(new InMemoryInvestmentFundsDao( new ArrayList<InvestmentFund>()));	       

	        controller.setInvestmentFundManager(simpleInvestmentFundManager);
	        
	        ModelAndView modelAndView = controller.handleRequest(null, null);
	        
	        assertNotNull(modelAndView.getModel());
	        assertEquals("fundsList", modelAndView.getViewName());
	        
			@SuppressWarnings("unchecked")
	        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
	        String nowValue = (String) modelMap.get("now");
	        assertNotNull(nowValue);
	    }

}
