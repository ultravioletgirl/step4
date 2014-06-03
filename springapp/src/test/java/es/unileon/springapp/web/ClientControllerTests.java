package es.unileon.springapp.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.repository.InMemoryClientDao;
import es.unileon.springapp.service.SimpleClientManager;

public class ClientControllerTests {


    @Test
    public void testHandleRequestView() throws Exception{
    	
        ClientController controller = new ClientController();
        
        SimpleClientManager clientManager = new SimpleClientManager();
        
        clientManager.setClientDao(new InMemoryClientDao( new ArrayList<Client>(), new ArrayList<InvestmentFundPack>()));
        
		controller.setClientManager(clientManager);

		
        ModelAndView modelAndView = controller.handleRequest(null, null);
        
        assertNotNull(modelAndView.getModel());
        assertEquals("client", modelAndView.getViewName());
        
		@SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}