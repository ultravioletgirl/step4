package es.unileon.springapp.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.handler.FundsHandler;
import es.unileon.springapp.service.SimpleClientManager;

public class ClientControllerTests {


    @Test
    public void testHandleRequestView() throws Exception{
    	
        ClientController controller = new ClientController();
        
        String id = "71463171D";
        Client client = new Client(id);
        
        SimpleClientManager clientManager = new SimpleClientManager();
        
        List<InvestmentFundPack> investmentFundPackList = new ArrayList<InvestmentFundPack>();
        
		FundsHandler invF = new FundsHandler("Santander Global", "Banco Santander", "Riesgo bajo-medio", 20000020, "Santanderrrr");
		InvestmentFund investmentFund = new InvestmentFund(invF, 10, 200.27, null, null, 1.5);
		FundsHandler invF2 = new FundsHandler("Herrero Global", "Banco Herrero", "Riesgo medio", 20000020, "Herreroooo");
		InvestmentFund investmentFund2 = new InvestmentFund(invF2, 5, 200.27, null, null, 1.5);

        InvestmentFundPack pack = new InvestmentFundPack(investmentFund, 4);
        InvestmentFundPack pack2 = new InvestmentFundPack(investmentFund2, 5);

        investmentFundPackList.add(pack);
        investmentFundPackList.add(pack2);

		client.setFunds(investmentFundPackList);
        clientManager.setClient(client);
        controller.setClientManager(clientManager);
       
        ModelAndView modelAndView = controller.handleRequest(null, null);
        
        assertNotNull(modelAndView.getModel());
        assertEquals("client", modelAndView.getViewName());
        
        //Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel();
		//@SuppressWarnings("unchecked")
		//List<InvestmentFundPack> packModel = (List<InvestmentFundPack>) modelMap.get("clientFunds");
       // assertEquals(2, packModel.size());
    }
}