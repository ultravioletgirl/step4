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
        assertEquals(1, clients.size());	
        assertEquals("71463171D", clients.get(0).getId());
    }

    @Test
    public void testGetPacks() {
        List<InvestmentFundPack>packs = clientDao.getPacks("71463171D");
        assertEquals(2, packs.size());	
        assertEquals("71463171D", packs.get(0).getClient().getId());
    }
    
    @Test
    public void testClient() {
        Client client = new Client("3718");
        clientDao.addClient(client);

        List<Client> clients = clientDao.getClients();
        assertEquals(2, clients.size());	
    }

}
