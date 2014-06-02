package es.unileon.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFundPack;

public class JPAClientTest {

	private ApplicationContext context;
    private ClientDao clientDao;

    @Before
    public void setUp() throws Exception {

        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        clientDao = (ClientDao) context.getBean("clientDao");

    }

    @Test
    public void testGetProductList() {
        List<Client> clients = clientDao.getClients();
        assertEquals(clients.size(), 1, 0);	
        assertEquals("71463171D", clients.get(0).getId());
    }

    @Test
    public void testGetPacks() {
        List<InvestmentFundPack>packs = clientDao.getPacks("71463171D");
        assertEquals(packs.size(), 2, 0);	
        assertEquals("71463171D", packs.get(0).getId());
    }
    
 /*   @Test
    public void testClient() {
        Client client = new Client("3718");
        clientDao.addClient(client);

        List<Client> clients = clientDao.getClients();
        assertEquals(clients.size(),2, 0);	
    }
*/
}
