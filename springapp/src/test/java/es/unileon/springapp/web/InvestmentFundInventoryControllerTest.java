package es.unileon.springapp.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.handler.FundsHandler;
import es.unileon.springapp.service.SimpleInvestmentFundManager;



public class InvestmentFundInventoryControllerTest {

	  @Test
	    public void testHandleRequestView() throws Exception{
	    	
		    InvestmentFundInventoryController controller = new InvestmentFundInventoryController();

	        SimpleInvestmentFundManager simpleInvestmentFundManager = new SimpleInvestmentFundManager();
	        
	        List<InvestmentFund> investmentFundList = new ArrayList<InvestmentFund>();
	        
			FundsHandler invF = new FundsHandler("Santander Global", "Banco Santander", "Riesgo bajo-medio", 20000020, "Santanderrrr");
			InvestmentFund investmentFund1 = new InvestmentFund(invF, 10, 200.27, null, null, 1.5);
			FundsHandler invF2 = new FundsHandler("Herrero Global", "Banco Herrero", "Riesgo medio", 20000020, "Herreroooo");
			InvestmentFund investmentFund2 = new InvestmentFund(invF2, 5, 200.27, null, null, 1.5);

	        investmentFundList.add(investmentFund1);
	        investmentFundList.add(investmentFund2);

	        simpleInvestmentFundManager.setInvestmentFunds(investmentFundList);
	        controller.setInvestmentFundManager(simpleInvestmentFundManager);
	       

	        ModelAndView modelAndView = controller.handleRequest(null, null);
	        
	        assertNotNull(modelAndView.getModel());
	        assertEquals("fundsList", modelAndView.getViewName());
	        
	       // Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel();

	      //  @SuppressWarnings("unchecked")
		//	List<InvestmentFund> packModel = (List<InvestmentFund>) modelMap.get("investmentFunds");
	       // assertEquals(2, packModel.size());
	    }

}
