package es.unileon.springapp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.fee.LinearFee;
import es.unileon.springapp.domain.handler.FundsHandler;
import es.unileon.springapp.repository.ClientDao;
import es.unileon.springapp.repository.InMemoryClientDao;
import es.unileon.springapp.repository.InMemoryInvestmentFundsDao;
import es.unileon.springapp.repository.InMemoryInvestmentFundsPackDao;
import es.unileon.springapp.repository.InvestmentFundDao;
import es.unileon.springapp.repository.InvestmentFundPackDao;

public class SimpleClientManagerTests {

	private SimpleClientManager clientManager;
	private SimpleInvestmentFundManager fundManager;

	private List<InvestmentFund> fundsList;
	private Client client1;
	private InvestmentFund investmentFund,investmentFund1;
	private FundsHandler invF, invF1;
	//private int countFunds = 2;
	
	@Before
    public void setUp() throws Exception  {
		fundManager = new SimpleInvestmentFundManager();
		fundsList = new ArrayList<InvestmentFund>();
		clientManager = new SimpleClientManager();
		
		String id = "71463171D";
	    client1 = new Client(id);
	    List<Client> list = new ArrayList<Client>();
	    list.add(client1);
	    ClientDao clientDao = new InMemoryClientDao(list);         
	    clientManager.setClientDao(clientDao);
        
		invF = new FundsHandler("Santander Global", "Banco Santander", "Riesgo bajo-medio", 20000020, "Santanderrrr");
    	invF1 = new FundsHandler("Herrero Global", "Banco Herrero", "Riesgo medio", 20000020, "Herreroooo");
    	LinearFee fee = new LinearFee(1.5,1.5);

        investmentFund = new InvestmentFund(invF, 10, 200.27, fee, fee, 1.5);
		investmentFund1 = new InvestmentFund(invF1, 5, 200.27, fee, fee, 1.5);
		investmentFund.setPurchaseAmount(0);
		investmentFund.setPurchaseAmount(0);
		fundsList.add(investmentFund);
		fundsList.add(investmentFund1);
		
		 InvestmentFundDao investmentFundDao = new InMemoryInvestmentFundsDao(fundsList);
	     fundManager.setInvestmentFundDao(investmentFundDao);
	     
	     List<InvestmentFundPack> packs = new ArrayList<InvestmentFundPack>();
	     InvestmentFundPackDao investmentFundPackDao = new InMemoryInvestmentFundsPackDao(packs);
	     fundManager.setInvestmentFundPackDao(investmentFundPackDao);
		
    }

	@Test
	public void getEmptyInvestmentFundsTest() {
		clientManager = new SimpleClientManager();
    	clientManager.setClientDao(new InMemoryClientDao(null));

		assertNull(clientManager.getClient());
	}


	@Test
	public void buyFundPackTestOk() throws NotEnoughParticipationsException{
		FundsHandler han =(FundsHandler) investmentFund.getId();
		fundManager.buyPack(han.getFundName(), 10, clientManager.getClient().get(0).getId());
		assertEquals(clientManager.getClient().get(0).getId(),client1.getId());
	}
	
	
	@Test(expected=NotEnoughParticipationsException.class)
	public void buyFundPackTestNotOk() throws NotEnoughParticipationsException{
		FundsHandler han =(FundsHandler) investmentFund1.getId();
		fundManager.buyPack(han.getFundName(), 10, clientManager.getClient().get(0).getId());

	}

}
