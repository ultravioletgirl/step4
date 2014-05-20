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
import es.unileon.springapp.domain.handler.FundsHandler;

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
		
		client1 = new Client();
		clientManager.setClient(client1);

		fundManager.setClient(clientManager);
		invF = new FundsHandler("Santander Global", "Banco Santander", "Riesgo bajo-medio", 20000020, "Santanderrrr");
    	invF1 = new FundsHandler("Herrero Global", "Banco Herrero", "Riesgo medio", 20000020, "Herreroooo");
    	        
        investmentFund = new InvestmentFund(invF, 10, 200.27, null, null, 1.5);
		investmentFund1 = new InvestmentFund(invF1, 5, 200.27, null, null, 1.5);
		fundsList.add(investmentFund);
		fundsList.add(investmentFund1);
		fundManager.setInvestmentFunds(fundsList);
		
    }

	@Test
	public void getEmptyInvestmentFundsTest() {
		assertTrue(client1.getFunds().isEmpty());
	}


 
	@Test
	public void getInvestmentFundsTest() throws NotEnoughParticipationsException{
		FundsHandler han =(FundsHandler) investmentFund.getId();
		fundManager.buyPack(han.getFundName(), 10);

		assertEquals(1,client1.getFunds().size());
		assertEquals(0, client1.getFunds().get(0).getProduct().getId().compareTo(fundsList.get(0).getId()));
	}
	

	@Test
	public void buyFundPackTestOk() throws NotEnoughParticipationsException{
		FundsHandler han =(FundsHandler) investmentFund.getId();
		fundManager.buyPack(han.getFundName(), 10);

		assertEquals(10,client1.getFunds().get(0).getAmount());

 
	}
	
	@Test
	public void buyFundPackTestOk2() throws NotEnoughParticipationsException{
		int packsToBuy = 3;
		InvestmentFundPack pack = new InvestmentFundPack(investmentFund1, packsToBuy );
		client1.addFundToList(pack);
		
		FundsHandler han =(FundsHandler) investmentFund.getId();
		fundManager.buyPack(han.getFundName(), packsToBuy);
		
		assertEquals(2,client1.getFunds().size());
		
		assertEquals(3, client1.getFunds().get(0).getAmount() );
		int difference = investmentFund1.getAmount() - client1.getFunds().get(0).getAmount();
		assertEquals(2, difference);
		
	}
	
	
	@Test(expected=NotEnoughParticipationsException.class)
	public void buyFundPackTestNotOk() throws NotEnoughParticipationsException{
		FundsHandler han =(FundsHandler) investmentFund1.getId();
		fundManager.buyPack(han.getFundName(), 10);

	}

}
